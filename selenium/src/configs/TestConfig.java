package configs;

public class TestConfig {
    public String url() {
        return "http://52.136.215.164:9000";
    }
    public String withLogin() {
        return "/user/login";
    }
    public String withLogout() {
        return "/user/logout";
    }
    public String withProduct() {
        return "/product/casio-mrp-700-1avef";
    }
    public String withBuy() {
        return "/cart/view";
    }


    public String login() {
        return "login";
    }
    public String password() {
        return "password";
    }
    public String email() {
        return "gg@mail.ru";
    }
    public String address() {
        return "address";
    }
    public String wrongPassword() {
        return "wrongPassword";
    }
    public String loginSuccess() {
        return "Вы успешно авторизованы";
    }
    public String loginFail() {
        return "Логин/пароль введены неверно";
    }
    public String normalInput() {
        return "casio";
    }
    public String normalSum() {
        return "$300";
    }
    public int numberOfCasioProducts() {
        return 44;
    }
    public int numberOfNullProducts() {
        return 0;
    }
    public String emptyCard() {
        return "Empty Cart";
    }
    public String orderSuccess() {
        return "Спасибо за Ваш заказ. В ближайшее время с Вами свяжется менеджер для согласования заказа";
    }



    public String loginElementName() {
        return "login";
    }
    public String passwordElementName() {
        return "password";
    }
    public String nameElementName() {
        return "name";
    }
    public String emailElementName() {
        return "email";
    }
    public String addressElementName() {
        return "address";
    }
    public String searchInputId() {
        return "typeahead";
    }
    public String productAddId() {
        return "productAdd";
    }
    public String loginSelectorSuccess() {
        return "div.alert.alert-success";
    }
    public String loginSelectorFail() {
        return "div.alert.alert-danger";
    }
    public String productSelector() {
        return "div.col-md-4.product-left.p-left";
    }
    public String simpleCard() {
        return "simpleCart_total";
    }
    public String buttonDefault() {
        return "btn-default";
    }
    public String deleteItemsSelector() {
        return "del-item";
    }
    public String closeSelector() {
        return "close";
    }
    public String cartSumItem() {
        return "cart-sum";
    }
    public String selectorSuccess() {
        return "alert-success";
    }
}
