package tests;
import com.codeborne.selenide.Condition;
import configs.TestConfig;
import entity.Methods;
import org.openqa.selenium.*;



import static com.codeborne.selenide.Selenide.*;

public class BuyCase {
    TestConfig config = new TestConfig();
    Methods m = new Methods();

    public void userMakeOrderWithNoItems() {
        m.checkCart();
        open(config.url()+config.withBuy());
        $(By.className(config.simpleCard())).shouldHave(Condition.text(config.emptyCard()));
    }

    public void userMakeOrderWithSomeItems() throws Exception {
        open(config.url()+config.withLogout());
        //login
        m.userLogin(config.login(), config.password());
        //add to card
        m.addProduct();
        //order
        open(config.url()+config.withBuy());
        m.clickCheck(config.buttonDefault());
        m.checkAlertDisplay(config.loginSelectorSuccess(), config.orderSuccess());
    }

    public void userMakeOrderWithSomeItemsWithRegistration() throws Exception {
        //add to card
        open(config.url()+config.withLogout());
        m.addProduct();
        //order
        open(config.url()+config.withBuy());
        //register
        m.register();
        m.checkAlertDisplay(config.loginSelectorSuccess(), config.orderSuccess());
    }
}
