package tests.usersTests;

import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class AuthorisationUserTest extends BaseTest {
    @Test
    public void authorisationUserTest(){

        ValidUserRequest requestBody = ValidUserRequest
                .builder()
                .userName(fakerLogin)
                .password("Qq1234!!")
                .build();
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
    }
}
