package tests;
import configs.TestConfig;
import entity.Methods;

public class AuthorizationCase {
    private TestConfig config = new TestConfig();
    private Methods m = new Methods();
    public void userLoginSuccess() throws Exception {
        m.userLogin(config.login(), config.password());
        m.checkAlertDisplay(config.loginSelectorSuccess(), config.loginSuccess());
    }
    public void userLoginFail() throws Exception {
        m.userLogin(config.login(), config.wrongPassword());
        m.checkAlertDisplay(config.loginSelectorFail(), config.loginFail());
    }
}
