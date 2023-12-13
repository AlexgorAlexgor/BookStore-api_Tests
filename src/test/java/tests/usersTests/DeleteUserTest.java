package tests.usersTests;

import dto.DeleteRequest;
import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DeleteUserTest extends BaseTest {

     @Test
    public void successDeleteUser(){
         ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();

         String userId =
                 postRequestUsers(endpoint, 201, requestBody)
                 .body().jsonPath().getString("userID");
         System.out.println("++userId++ : " + userId);

         String token =
                 postRequestUsers(endpointGenerateToken, 200, requestBody)
                         .body().jsonPath().getString("token");
         System.out.println("++token++ : " + token);

         postRequestUsers(endpointAuthorized, 200, requestBody);


     DeleteRequest deleteRequest = DeleteRequest.builder().userId(userId).build();

     //   Response response = deleteRequestForUsers(endpoint+"/"+userId ,200,userId);
      //   Response response = deleteRequestForUsers(endpoint+"/"+userId,200,deleteRequest,token,"UserId",userId);
        // Response response = deleteRequestForUsers(endpoint+"/"+userId ,401,userId);
         Response response = deleteRequestForUsers(endpoint+"/"+userId,204,deleteRequest,token);


    }

}
