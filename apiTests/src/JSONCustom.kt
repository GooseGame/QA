import org.json.simple.JSONObject

class JSONCustom {
    private val obj = JSONObject()

    init {
        obj["category_id"] = 1
        obj["title"] = "no more Eldors posts!!!"
        obj["content"] = "ITS TIME TO STOP IT"
        obj["price"] = 35
        obj["old_price"] = 36
        obj["status"] = 1
        obj["keywords"] = "35"
        obj["description"] = "hippity hoppity its not your property"
        obj["hit"] = 1
    }

    fun changeValue(key: String, value: String) {
        obj.remove(key)
        obj[key] = value
    }

    fun changeValue(key: String, value: Int) {
        obj.remove(key)
        obj[key] = value
    }


    fun putArrayInKeys() {
        obj["keywords"] = "keyword1, keyword2, Arkadiy"
    }


    fun params(): JSONObject {
        return obj
    }
}