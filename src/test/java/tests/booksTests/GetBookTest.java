package tests.booksTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.GetRequestBook;
import dto.GetRequestBooks;
import dto.ValidUserRequest;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;
import java.util.Arrays;

public class GetBookTest extends BaseTest {
    @Test
    public void readBookForNewUser() {
        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId =
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : " + userId);

        String result =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("result");
        System.out.println("++result++ : " + result);

        GetRequestBooks requestBodyBooks = GetRequestBooks.builder()
                //      .userId(userId)
                .isbn("9781449325860")
                .build();

        getRequestForBook(endpointBook + "?ISBN=9781449325860", 400);

    }

    @Test
    public void readBookForExistUser() {
 /*       ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId=
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : "+userId);

        String result =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("result");
        System.out.println("++result++ : " + result);
*/
        GetRequestBook requestBodyBook = GetRequestBook
                .builder()
               .userId("d794876f-9775-4524-8b68-2baa61234277")
                //.userId(userId)
                .isbn("9781449325862")
                .build();
// Example JSON string
        String book =
                getRequestForBook(endpointBook + "?ISBN=9781449325862", 200,requestBodyBook)
                        .body().jsonPath()
                        //.getObject("", GetBooksTest.class)
                        .getString("book")
                    //    .toString()
        ;
    }
}