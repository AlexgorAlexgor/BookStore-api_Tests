package tests;

import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;

public class AuthorisationUserTest extends BaseTest{
    @Test
    public void authorisationUserTest(){

        ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        String userId = postRequest(endpoint, 201, requestBody)
                .body().jsonPath().getString("userID");

        System.out.println("++userId++ : " + userId);
        //   ValidUserRequest requestBodyWithToken = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String code =
                postRequest(endpointAuthorized, 406, requestBody)
                        .body().jsonPath().getString("code");
        System.out.println("++code++ : " + code);
        String message =
                postRequestForToken(endpointGenerateToken, 406, requestBody)
                        .body().jsonPath().getString("message");
        System.out.println("++message++ : " + message);

        // getRequestWithToken(endpointGenerateToken, 200, token);
        String token =
                postRequestForToken(endpointGenerateToken, 200, requestBody)
                        .body().jsonPath().getString("token");
        System.out.println("++token++ : " + token);

    }
}
