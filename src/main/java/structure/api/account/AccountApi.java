package structure.api.account;

import framework.utilities.ApiUtility;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.Map;

import static structure.constant.StringConstant.*;
import static structure.constant.ApiConstant.*;
import static framework.logger.Logger.*;
import static java.lang.String.*;

public class AccountApi {

    private AccountApi() {
        throw new InstantiationError("Should not instantiate static class");
    }

    public static void createAccount(String login, String password) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put(USER_NAME, login);
        parameters.put(PASSWORD, password);
        infoAction(format("set request for user created with following data: username[%s], password [%s]", login, password));
        Response response = ApiUtility.requestPost(CREATE_USER_METHOD, parameters);
        infoAction(format("api response: \n%s", response.getBody().asString()));
    }
}
