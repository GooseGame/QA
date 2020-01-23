import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.response.ResponseBodyExtractionOptions
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo


class MainTest {
    private fun makeBody(jsonCustom: JSONCustom) :ResponseBodyExtractionOptions {
        return given()
                    .contentType("application/json")
                    .body(jsonCustom.params().toString())
                    .`when`()
                    .post("")
                    .then()
                    .body("status", equalTo(1))
                    .extract().response()
    }

    @Test fun getAllDefault() {
        given()
            .`when`()
            .get(Data().PRODUCTS_URL)
            .then().assertThat().statusCode(200)
        println("Response code 200, all good")
    }

    @Test
    fun iNeedToAuthorize() {
        given()
            .auth()
            .preemptive()
            .basic(Data().LOGIN, Data().PASSWORD)
            .`when`()
            .get(Data().ADD_URL)
            .then()
            .assertThat()
            .statusCode(200).body("status", equalTo(0))
        println("authorized normally")
    }

    @Test fun postDefault() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        makeBody(json)
        println("successfully added new item")
    }
    @Test fun postWithRussianText() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("title", "остановите Элдора!!!")
        makeBody(json)
        println("successfully added new item with russian title")
    }
    @Test fun postWithNoText() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("title", "")
        makeBody(json)
        println("successfully added new item with russian title")
    }

    @Test fun postWithOutOfRangeCategory() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("category", 42)
        makeBody(json)
        println("successfully added new item with out of limit category")
    }
    @Test fun postWithZeroCategory() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("category", 0)
        makeBody(json)
        println("successfully added new item with zero category")
    }
    @Test fun postWithNegativeCategory() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("category", -1)
        makeBody(json)
        println("successfully added new item with negative category")
    }

    @Test fun postWithReallyBigPrice() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("price", Integer.MAX_VALUE+1)
        makeBody(json)
        println("successfully added new item with really big price")
    }
    @Test fun postWithZeroPrice() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("price", 0)
        makeBody(json)
        println("successfully added new item with zero price")
    }
    @Test fun postWithNegativePrice() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("price", -1)
        makeBody(json)
        println("successfully added new item with negative price")
    }

    @Test fun postWithSmallerOldPrice() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("old_price", 33)
        makeBody(json)
        println("successfully added new item with pretty good deal")
    }
    @Test fun postWithSameOldPrice() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("old_price", 35)
        makeBody(json)
        println("successfully added new item without sale")
    }

    @Test fun postWithZeroStatus() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("status", 0)
        makeBody(json)
        println("successfully added new item without sale")
    }

    @Test fun postWithZeroKeyword() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("keywords", "")
        makeBody(json)
        println("successfully added new item without keywords")
    }
    @Test fun postWithSomeKeywords() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.putArrayInKeys()
        makeBody(json)
        println("successfully added new item with zero hit")
    }

    @Test fun postWithZeroDescription() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("description", "")
        makeBody(json)
        println("successfully added new item without description")
    }
    @Test fun postWithRussianDescription() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("description", "хиппити хоппити итс нот ёр проперти")
        makeBody(json)
        println("successfully added new item with russian description")
    }

    @Test fun postWithZeroHit() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        json.changeValue("hit", 0)
        makeBody(json)
        println("successfully added new item with zero hit")
    }

    @Test fun postWithEdit() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        val body = makeBody(json)
        println("successfully added new item that will be edited")
        val id : Int = body.path("id")
        json.changeValue("id", id)
        json.changeValue("title", "there is another")
        RestAssured.baseURI = Data().EDIT_URL
        given()
            .contentType("application/json")
            .body(json.params().toString())
            .`when`()
            .post("")
            .then()
            .body("status", equalTo(1))
            .extract().body()
        println("successfully edited item")
    }

    @Test fun postAndDelete() {
        RestAssured.baseURI = Data().ADD_URL
        val json = JSONCustom()
        val body = makeBody(json)
        println("successfully added new item that will be deleted")
        val id : Int = body.path("id")

        given()
            .auth()
            .preemptive()
            .basic(Data().LOGIN, Data().PASSWORD)
            .`when`()
            .get(Data().DELETE_URL)
            .then()
            .assertThat()
            .statusCode(200)
        println("successfully deleted item")
    }

}