package entity;

import configs.TestConfig;
import org.openqa.selenium.By;


import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Methods {
    private TestConfig config = new TestConfig();
        public void userLogin(String login, String password) {
            open(config.url()+config.withLogin());
            $(By.name(config.loginElementName())).setValue(login);
            $(By.name(config.passwordElementName())).setValue(password).pressEnter();
        }
    public void search(String value) {
        open(config.url());
        $(By.id(config.searchInputId())).setValue(value).pressEnter();
    }
    public void addProduct() {
        open(config.url()+config.withProduct());
        $(By.id(config.productAddId())).click();
    }
    public void checkCart() {
        open(config.url());
        if (!$(By.className(config.simpleCard())).text().equals(config.emptyCard())) {
            $(By.className(config.simpleCard())).click();
            $(By.className(config.deleteItemsSelector())).click();
            $(By.className(config.closeSelector())).click();
        }
    }
    public void register() {
        int randomNumber = new Random().nextInt(1000);
        $(By.name(config.loginElementName())).setValue(config.login()+randomNumber);
        $(By.name(config.passwordElementName())).setValue(config.password());
        $(By.name(config.nameElementName())).setValue(config.nameElementName());
        $(By.name(config.emailElementName())).setValue(randomNumber+config.email());
        $(By.name(config.addressElementName())).setValue(config.address());
        $(By.className(config.buttonDefault())).click();
    }
    public void checkAlertDisplay(String alertSelector, String message) throws Exception {
        if ($(alertSelector).isDisplayed()) {
            $(alertSelector).shouldHave(text(message));
        }
        else throw new Exception();
    }
    public void clickCheck(String selector) throws Exception {
        if ($(By.className(config.buttonDefault())).isDisplayed()){
            $(By.className(config.buttonDefault())).click();
        }
        else throw new Exception();
    }
}
