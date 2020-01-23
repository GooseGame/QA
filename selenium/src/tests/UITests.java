package tests;

import org.junit.jupiter.api.Test;

public class UITests {
    @Test
    public void authorizationCase() throws Exception {
        AuthorizationCase testCase = new AuthorizationCase();
        testCase.userLoginSuccess();
        testCase.userLoginFail();
    }
    @Test
    public void searchCase() {
        SearchCase testCase = new SearchCase();
        testCase.userEmptySearch();
        testCase.userSearchSuccess();
    }
    @Test
    public void cartCase() {
        CartCase testCase = new CartCase();
        testCase.userCheckCardWithOneProduct();
    }
    @Test
    public void buyCase() throws Exception {
        BuyCase testCase = new BuyCase();
        testCase.userMakeOrderWithNoItems();
        testCase.userMakeOrderWithSomeItems();
        testCase.userMakeOrderWithSomeItemsWithRegistration();
    }
}
