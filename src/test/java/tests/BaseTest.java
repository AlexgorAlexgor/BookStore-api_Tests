package tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    final static String BASE_URI = "https://demoqa.com/Account/v1";

    protected final static String endpoint = "/User";
    protected final static String endpointGetUser = "/User/{UUID}"; //https://demoqa.com/Account/v1/User/{UUID}
    protected final static String endpointAuthorized = "/Authorized";
    protected final static String endpointGenerateToken = "/GenerateToken";

    Faker faker = new Faker();
    protected String fakerLogin = faker.name().username();


    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();

    public Response postRequest(String endPoint, Integer responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    public Response postRequestForToken(String endPoint, Integer responseCode, Object body) {
        Response response = RestAssured.given()
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
    public static Response getRequestWithToken(String endPoint, Integer responseCode,String token) {
        Response response = (Response) RestAssured.given()
                .spec(specification)
                .when()
                .header("Authorization","Bearer "+token )
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
        //    .jsonPath().getObject("", GetRequest.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
   // public static Response getRequest(String endPoint, Integer responseCode, Object body) {
    public static Response getRequest(String endPoint, Integer responseCode) {
        Response response = (Response) RestAssured.given()
                .spec(specification)
                .when()
                .log().all()
                .get(endPoint)
                .then().log().all()
                .extract().response();
            //    .jsonPath().getObject("", GetRequest.class);
        //      .extract().body().jsonPath().getObject("data", UserDataResponse.class);
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response getRequestWithParam(String endPoint, Integer responseCode, String paramName, String value) {
        Response response = RestAssured.given()
                .spec(specification)
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
                .spec(specification)
                .body(body)
                .when()
                .log().all()
                .put(endPoint)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }

    public Response deleteRequest(String endPoint, Integer responseCode, String value) {

        Response response = RestAssured.given()
                .spec(specification)
              //  .body(body)
                .when()
                .pathParam("UserId", value)
                .log().all()
                .delete(endpointGetUser)
                .then().log().all()
                .extract().response();
        response.then().assertThat().statusCode(responseCode);
        return response;
    }
// protected Response deleteRequest(String endPoint, int responseCode, String value) {
//        Response response = RestAssured.given()
//                .spec(spec)
//                .when()
//                .pathParam("UserId", value)
//                .log().all()
//                .delete(endPoint)
//                .then().log().all()
//                .extract().response();
//        response.then().assertThat().statusCode(responseCode);
//        return response;
}
