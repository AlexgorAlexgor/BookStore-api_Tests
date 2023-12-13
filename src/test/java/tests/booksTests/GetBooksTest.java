package tests.booksTests;

import dto.GetRequestBooks;
import dto.ValidBooksRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class GetBooksTest extends BaseTest {
@Test
    public void readListOfBooksTest() {
    ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
    String userId=
            postRequestUsers(endpoint, 201, requestBodyUser)
                    .body().jsonPath().getString("userID");
    System.out.println("++userId++ : "+userId);

    String result =
            postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                    .body().jsonPath().getString("result");
    System.out.println("++result++ : " + result);

        GetRequestBooks requestBodyBooks = GetRequestBooks.builder()
                  //      .userId(userId).isbn("9781449325860")
                         .build();
       // String books =
       //         postRequestBooks(endpointBooks, 200, requestBodyBooks)
    getRequestForBooks(endpointBooks, 200);
    }
}