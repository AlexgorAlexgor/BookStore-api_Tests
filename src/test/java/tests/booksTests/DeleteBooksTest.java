package tests.booksTests;

import dto.DeleteRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DeleteBooksTest extends BaseTest {
@Test
    public void deleteBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId=
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : "+userId);

        String result =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("result");
        System.out.println("++result++ : " + result);

    //String code =
            postRequestUsers(endpointAuthorized, 200, requestBodyUser);
                //    .body().jsonPath().getString("code");
    //System.out.println("++code++ : " + code);

        DeleteRequest requestBodyBooks = DeleteRequest.builder()
                .UserId(userId)
              //  .isbn("9781449325860")
                .build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
       // String message =

    deleteRequestForBooks(endpointBooks+"?UserId="+userId,401);
// deleteRequestForBooks(endpointBooks+"?UserId="+userId,204);

   // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204,userId);
                        //https://demoqa.com/BookStore/v1/Books?UserId=025f6005-0560-4c00-b01c-998010c9b5b9
              //  .body().jsonPath().getString("message");

     // System.out.println("++message++ : " + message);

    }
    @Test
    public void deleteBooksWithParamTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId=
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : "+userId);

        String result =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("result");
        System.out.println("++result++ : " + result);

        //String code =
        postRequestUsers(endpointAuthorized, 200, requestBodyUser);
        //    .body().jsonPath().getString("code");
        //System.out.println("++code++ : " + code);

        DeleteRequest requestBodyBooks = DeleteRequest.builder()
                .UserId(userId)
                //  .isbn("9781449325860")
                .build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        // String message =
        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204);
       // deleteRequestWithParamForBooks(endpointBooks+"?UserId="+userId,401,"UserId",userId);
        deleteRequestWithParamForBooks(endpointBooks,204,"UserId",userId);

        // deleteRequestForBooks(endpointBooks+"?UserId="+userId,204,userId);
        //https://demoqa.com/BookStore/v1/Books?UserId=025f6005-0560-4c00-b01c-998010c9b5b9
        //  .body().jsonPath().getString("message");

        // System.out.println("++message++ : " + message);

    }
}