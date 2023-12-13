package tests.booksTests;

import dto.DeleteRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DeleteBookTest extends BaseTest {
    @Test
    public void deleteBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName("belia.beahan@gmail.com").password("Qq1234!!").build();
   /*     String userId =
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : " + userId);
*/        String token =
                "Bearer "+postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("token");
        System.out.println("++ token ++ : " + token);

        //String code =
        postRequestUsers(endpointAuthorized, 200, requestBodyUser);
        //    .body().jsonPath().getString("code");
        //System.out.println("++code++ : " + code);

        DeleteRequest requestDeleteBodyBook = DeleteRequest
                .builder()
                .userName(fakerLogin)
                .password("Qq1234!!")
                .userId("d794876f-9775-4524-8b68-2baa61234277")
              //  .header("Authorization",token)
                .isbn("9781449325862")
              //  .param("isbn","9781449325862")
                .build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        // String message =
        deleteRequestForBook(endpointBook, 401, requestDeleteBodyBook);
        // deleteRequestForBooks(endpointBooks,204,requestDeleteBodyBook,token);

        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204,requestDeleteBodyBook,token);
        //deleteRequestForBooks(endpointBooks+"?UserId="+userId,204);

        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204,userId);
        //https://demoqa.com/BookStore/v1/Books?UserId=025f6005-0560-4c00-b01c-998010c9b5b9
        //  .body().jsonPath().getString("message");

        // System.out.println("++message++ : " + message);

    }

    @Test
    public void deleteBooksWithParamTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId =
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : " + userId);

        String result =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("result");
        System.out.println("++result++ : " + result);

        //String code =
        postRequestUsers(endpointAuthorized, 200, requestBodyUser);
        //    .body().jsonPath().getString("code");
        //System.out.println("++code++ : " + code);

        DeleteRequest requestBodyBooks = DeleteRequest.builder()
                .userId(userId)
                //  .isbn("9781449325860")
                .build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        // String message =
        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204);
        deleteRequestWithParamForBooks(endpointBooks + "?UserId=" + userId, 401, "UserId", userId);
        //deleteRequestWithParamForBooks(endpointBooks,401,"UserId",userId);

        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204,userId);
        //https://demoqa.com/BookStore/v1/Books?UserId=025f6005-0560-4c00-b01c-998010c9b5b9
        //  .body().jsonPath().getString("message");

        // System.out.println("++message++ : " + message);

    }
}