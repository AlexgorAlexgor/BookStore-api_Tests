package tests.booksTests;

import dto.GetRequestBooks;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class GetBookTest extends BaseTest {
@Test
    public void readBookTest() {
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
                  //      .userId(userId)
                      .isbn("9781449325860")
                         .build();
  // getRequestForBook(endpointBook, 200);
   // getRequestForBook(endpointBook, 504);
//https://demoqa.com/BookStore/v1/Book?ISBN=9781449325860
    //getRequestForBook(endpointBook+"?ISBN=9781449325860", 504);
   getRequestForBook(endpointBook+"?ISBN=9781449325860", 400);

    }
}