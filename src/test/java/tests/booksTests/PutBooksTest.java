package tests.booksTests;

import dto.PutRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class PutBooksTest extends BaseTest {
    @Test
    public void putBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName("belia.beahan@gmail.com").password("Qq1234!!").build();
           String token =
                "Bearer "+postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("token");
        System.out.println("++ token ++ : " + token);

        postRequestUsers(endpointAuthorized, 200, requestBodyUser);

        PutRequest requestPutBodyBooks = PutRequest
                .builder()
                //  .userName("belia.beahan@gmail.com")
                // .password("Qq1234!!")

                .userId("d794876f-9775-4524-8b68-2baa61234277")
                //.header("Authorization",token)
                .isbn("9781449325860")
                //  .param("isbn","9781449325862")
                .build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        // String message =
        putRequestForBook(endpointPutBooks, 400, requestPutBodyBooks,token);
    }
}