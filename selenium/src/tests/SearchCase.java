package tests;
import com.codeborne.selenide.CollectionCondition;
import configs.TestConfig;
import entity.Methods;
import static com.codeborne.selenide.Selenide.*;

public class SearchCase {
    private TestConfig config = new TestConfig();
    private Methods m = new Methods();

    public void userSearchSuccess() {
        m.search(config.normalInput());
        $$(config.productSelector()).shouldHave(CollectionCondition.size(config.numberOfCasioProducts()));
    }

    public void userEmptySearch() {
        m.search("");
        $$(config.productSelector()).shouldHave(CollectionCondition.size(config.numberOfNullProducts())); //ето bug
    }
}
