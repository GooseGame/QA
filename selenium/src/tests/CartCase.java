package tests;
import com.codeborne.selenide.Condition;
import configs.TestConfig;
import entity.Methods;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;

public class CartCase {
    TestConfig config = new TestConfig();
    Methods m = new Methods();

    public void userCheckCardWithOneProduct() {
        m.addProduct();
        $(By.className(config.cartSumItem())).shouldHave(Condition.text(config.normalSum()));
    }
}
