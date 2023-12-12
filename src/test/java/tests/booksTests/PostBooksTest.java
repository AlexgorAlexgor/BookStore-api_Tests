package tests.booksTests;

import dto.ValidBooksRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class PostBooksTest extends BaseTest {
@Test
    public void addListOfBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId=
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : "+userId);

        String token =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("token");
        System.out.println("++token++ : " + token);

    //String code =
   //         postRequestUsers(endpointAuthorized, 200, requestBodyUser);
               //     .body().jsonPath().getString("code");
  //  System.out.println("++code++ : " + code);

        ValidBooksRequest requestBodyBooks = ValidBooksRequest.builder().userId(userId).isbn("9781449325860").build();
        //   ValidUserRequest requestBodyWithToken = requestBody;
        String isbn =
                postRequestBooks(endpointBooks, 201, requestBodyBooks)
                .body().jsonPath().getString("isbn");

      System.out.println("++isbn++ : " + isbn);

    }
}