package structure.api.bookstore;

import framework.utilities.ApiUtility;
import io.restassured.response.Response;

import java.util.LinkedHashMap;

import static framework.logger.Logger.infoAction;
import static java.lang.String.format;
import static structure.constant.ApiConstant.*;

public class BookStoreApi {

    private BookStoreApi() {
        throw new InstantiationError("Should not instantiate static class");
    }

    public static Response getBookList() {
        infoAction("set request for getting books");
        Response response = ApiUtility.requestGet(GET_BOOKS_METHOD, new LinkedHashMap<>());
        infoAction(format("api response: \n%s", response.getBody().asString()));
        return response;
    }
}
