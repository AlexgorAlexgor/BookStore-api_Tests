package tests.booksTests;

import dto.GetRequestBooks;
import dto.ValidBooksRequest;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.Arrays;

public class GetBooksTest extends BaseTest {
@Test
    public void readListOfBooksTest() {
    ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
    String userId=
            postRequestUsers(endpoint, 201, requestBodyUser)
                    .body().jsonPath().getString("userID");
    System.out.println("++userId++ : "+userId);

    String token =
            postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                    .body().jsonPath().getString("token");
    System.out.println("++ token ++ : " + token);

        GetRequestBooks requestBodyBooks = GetRequestBooks.builder()
                  //      .userId(userId).isbn("9781449325860")
                         .build();
        books =
       //         postRequestBooks(endpointBooks, 200, requestBodyBooks)
  // String collectionOfIsbns=
           // String.valueOf(
            new String[]{
                     getRequestForBooks(endpointBooks, 200,token,requestBodyBooks)
                     .body().jsonPath()
                     //.getObject("", GetBooksTest.class)
                     .getString("books")
    // }
            //.length()
         //   .substring(1,524)
       //                     .substring(0,523)

            // .indexOf("]"))
            //.trim()
            } ;
    System.out.println("++books++ : ");
    Arrays.stream(books).forEach(System.out::println);

    }
}