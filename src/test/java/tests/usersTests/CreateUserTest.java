package tests.usersTests;

import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class CreateUserTest extends BaseTest {

    @Test
    public void successfulCreateUser() {
        ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();

       String userId=
               postRequestUsers(endpoint, 201, requestBody)
               .body().jsonPath().getString("userID");
        System.out.println(userId);
    }
}
