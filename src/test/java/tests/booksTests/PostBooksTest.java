package tests.booksTests;

import dto.GetRequestBooks;
import dto.ValidBooksRequest;
import dto.ValidUserRequest;
import lombok.val;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static dk.brics.automaton.StringUnionOperations.build;
import static dto.GetRequestBooks.*;

public class PostBooksTest extends BaseTest {
    @Test
    public void addEmptyListOfBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId =
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : " + userId);

        String token =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("token");
        System.out.println("++token++ : " + token);

        //String code =
        postRequestUsers(endpointAuthorized, 200, requestBodyUser);
        //     .body().jsonPath().getString("code");
        //  System.out.println("++code++ : " + code);

        ValidBooksRequest requestBodyBooks = ValidBooksRequest
                .builder()
                .userId(userId)
                .collectionOfIsbns(books)
                //.isbn(fakerISBN)
                //   .}]

                .build();

        //  String isbn =
        postRequestBooks(endpointBooks + "?UserId=" + userId, 504, requestBodyBooks, token);
        //   .body().jsonPath().getString("isbn");
        // System.out.println("++isbn++ : " + isbn);

    }

    @Test
    public void addListOfBooksTest() {

        ValidUserRequest requestBodyUser = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        String userId =
                postRequestUsers(endpoint, 201, requestBodyUser)
                        .body().jsonPath().getString("userID");
        System.out.println("++userId++ : " + userId);

        String token =
                postRequestUsers(endpointGenerateToken, 200, requestBodyUser)
                        .body().jsonPath().getString("token");
        System.out.println("++token++ : " + token);

        postRequestUsers(endpointAuthorized, 200, requestBodyUser);

        //  GetRequestBooks getRequestBooks ;
        //= GetRequestBooks;
        //  .builder()
        //     // .userId(userId).isbn("9781449325860")
        //  .build();
        books =
                new String []{
                        getRequestForBooks(endpointBooks, 200,token,requestBodyUser)
                                .body().jsonPath()
                                //.getJsonObject("")
                                //.getObject("", GetBooksTest.class)
                                .getString("books")
                                .substring(1,524)}
                            ;
            System.out.println("++books++ : ");
             Arrays.stream(books).forEach(System.out::println);

         /*   String isbn0 = "isbn";
            String isbn1 = "isbn";

            String number9781593277574 = "9781593277574";
            String number9781449337711 = "9781449337711";
            Object collectionOfIsbns; [{isbn0:number9781449337711},
                    {isbn1:number9781593277574}]*/

            ValidBooksRequest getRequestBooks = ValidBooksRequest
                    .builder()
                    .userId(userId)
                    .collectionOfIsbns(books)
                    // .collectionOfIsbns []{isbn: number9781593277574 }{isbn:number9781449337711 }
                    .build();
     /*   //  ValidBooksRequest getRequestBooks = ValidBooksRequest
        getRequestBooks = builder()
                //.userId()
                .collectionOfIsbns()
                //.isbn(fakerISBN)
                //   .}]
                .build();*/

            //  String isbn =
            postRequestBooks(endpointBooks, 400, getRequestBooks, token);
    }
}