package tests.usersTests;

import dto.DeleteRequest;
import dto.GetRequest;
import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DeleteUserTest extends BaseTest {

     @Test
    public void successDelete(){
         ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
         //   ValidUserRequest requestBodyWithToken = requestBody;
         String userId = postRequestUsers(endpoint, 201, requestBody)
                 .body().jsonPath().getString("userID");

         System.out.println("++userId++ : " + userId);
         //   ValidUserRequest requestBodyWithToken = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();

     /*   String message =
                postRequestUsers(endpointGenerateToken, 406, requestBody)
                        .body().jsonPath().getString("message");
        System.out.println("++message++ : " + message);
*/
         // getRequestWithToken(endpointGenerateToken, 200, token);
         String token =
                 postRequestUsers(endpointGenerateToken, 200, requestBody)
                         .body().jsonPath().getString("token");
         System.out.println("++token++ : " + token);

         //String code =
         postRequestUsers(endpointAuthorized, 200, requestBody);
         //         .body().jsonPath().getString("code");
         // System.out.println("++code++ : " + code);

         GetRequest getRequest = GetRequest.builder().build();
         //getRequestWithToken(endpointGetUser, 401,token);
         getRequestWithToken(endpoint+"/"+userId, 200,token);
         // getRequestWithToken(endpoint+"?User="+userId, 200,token);


     DeleteRequest deleteRequest = DeleteRequest.builder().UserId("").build();

     //   Response response = deleteRequestForUsers(endpoint+"/"+userId ,200,userId);
         Response response = deleteRequestForUsers(endpoint+"/"+userId ,204,userId);
        // Response response = deleteRequestForUsers(endpoint+"/"+userId ,401,userId);

    }

}
