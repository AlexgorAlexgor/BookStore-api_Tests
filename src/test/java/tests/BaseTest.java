package tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    final static String BASE_URI_USERS = "https://demoqa.com/Account/v1";
    final static String BASE_URI_BOOKS = "https://demoqa.com/BookStore/v1";

    protected final static String endpoint = "/User";
    protected final static String endpointGetUser = "/User/{UUID}"; //https://demoqa.com/Account/v1/User/{UUID}
    protected final static String endpointAuthorized = "/Authorized";
    protected final static String endpointGenerateToken = "/GenerateToken";

    protected final static String endpointBook = "/Book";
    protected final static String endpointBooks = "/Books";
    //protected final static String endpointBooksUserId= = "/Books?UserId=";
    //https://demoqa.com/BookStore/v1/Books?UserId=025f6005-0560-4c00-b01c-998010c9b5b9
    protected final static String endpointPutBooks = "/Books/9781449325862";

    Faker faker = new Faker();
    protected String fakerLogin = faker.internet().emailAddress().toLowerCase();
    protected String fakerISBN = faker.numerify("9781449325863");
    protected String[] books ;

    static RequestSpecification specificationUsers = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI_USERS)
            .setContentType(ContentType.JSON)
            .build();

    static RequestSpecification specificationBooks = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI_BOOKS)
            .setContentType(ContentType.JSON)
            .build();

    public Response postRequestUsers(String endpoint, Integer responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(specificationUsers)
                .body(body)
                .when()
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response postRequestBooks(String endpointBooks, Integer responseCode, Object body, String token) {
        Response response = RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization", "Bearer " + token)
              //  .pathParam("UserId", userId)
                //.and().pathParam( "isbn",fakerISBN)
                .log().all()
                .post(endpointBooks)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response getRequestWithToken(String endpoint, Integer responseCode, String token, Object body) {
        Response response = (Response) RestAssured.given()
                .spec(specificationUsers)
                .body(body)
                .when()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        //    .jsonPath().getObject("", GetRequestBook.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    // public static Response getRequestForUsers(String endPoint, Integer responseCode, Object body) {
    public static Response getRequestForUsers(String endPoint, Integer responseCode) {
        Response response = (Response) RestAssured.given()
                .spec(specificationUsers)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        //    .jsonPath().getObject("", GetRequestBook.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response getRequestForBooks(String endpointBooks, Integer responseCode, String token, Object body) {
        Response response = (Response) RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .get(endpointBooks)
                .then().log().all()
                .extract().response();
        //    .jsonPath().getObject("", GetRequestBook.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response getRequestWithParam(String endPoint, Integer responseCode, String paramName, String value) {
        Response response = RestAssured.given()
                .spec(specificationUsers)
                .when()
                .pathParam("UserId", value)
                //  .pathParam(paramName, id)
                .log().all()
                .get(endpointGetUser)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response putRequest(String endPoint, Integer responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(specificationUsers)
                .body(body)
                .when()
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    //  public Response deleteRequestForUsers(String endpoint, Integer responseCode, Object body,String token, String paramName, String value) {
    public Response deleteRequestForUsers(String endpoint, Integer responseCode, Object body, String token) {

        Response response = RestAssured.given()
                .spec(specificationUsers)
                .body(body)
                .when()
                //  .pathParam("UserId", "userId")
                .header("Authorization", "Bearer " + token)
                .log().all()
                .delete(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    // public Response deleteRequestForBooks(String endpointBooks, Integer responseCode, String value) {
    public Response deleteRequestForBooks(String endpointBooks, Integer responseCode, Object body, String token) {
        Response response = RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization", "Bearer " + token)
                //    .pathParam("UserId", value)
                .log().all()
                .delete(endpointBooks)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response deleteRequestWithParamForBooks(String endpointBooks, Integer responseCode, String paramName, String value) {
        Response response = RestAssured.given()
                .spec(specificationBooks)
                .when()
                // .request("?UserId="+value)
                //.pathParam("UserId", value)
               // .pathParam(paramName, value)
                .log().all()
                .delete(endpointBooks)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response getRequestForBook(String endpointBook, Integer responseCode) {
        Response response = (Response) RestAssured.given()
                .spec(specificationBooks)
                .when()
                .log().all()
                .get(endpointBook)
                .then().log().all()
                .extract().response();
        //    .jsonPath().getObject("", GetRequestBook.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response getRequestForBook(String endpointBook, Integer responseCode, Object body) {
        Response response = (Response) RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IktpcmEuUGFjb2NoYTdAeWFob28uY29tIiwicGFzc3dvcmQiOiJRcTEyMzQhISEiLCJpYXQiOjE3MDI0MDk2NDF9.sOA-Ha1cv4EBK3zGWirewYr2AQsNL8y52t_QhDi_mSQ " )
                .param("isbn","9781449325862")
                .log().all()
                .get(endpointBook)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response deleteRequestForBook(String endpointBook, Integer responseCode, Object body,String token) {
        Response response = (Response) RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization",token)
                .param("isbn","9781449325862")
                .log().all()
                .delete(endpointBook)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public static Response putRequestForBook(String endpointBook, Integer responseCode, Object body,String token) {
        Response response = (Response) RestAssured.given()
                .spec(specificationBooks)
                .body(body)
                .when()
                .header("Authorization",token)
                //.basePath("9781449325864")
               // .param("9781449325864")
                .log().all()
                .put(endpointPutBooks)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
}
