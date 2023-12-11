package tests;

import dto.GetRequest;
import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest{

    @Test
    public void successfulCreateUser() {
        ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
       String userId= postRequest(endpoint, 201, requestBody)
               .body().jsonPath().getString("userID");
        System.out.println(userId);

        //public Response postRequest(String endPoint, Integer responseCode, Object body) {
        //        Response response = RestAssured.given()
        //                .spec(specification)
        //                .body(body)
        //                .when()
        //                .log().all()
        //                .post(endpoint)
        //                .then().log().all()
        //                .extract().response();
        //        response.then().assertThat().statusCode(responseCode);
        //        return response;
        //    }
    }
   /* @Before

    {
        ValidUserRequest requestBody = ValidUserRequest.builder().userName(fakerLogin).password("Qq1234!!").build();
        postRequest(endpoint, 201, requestBody);

        postRequest(endpointAuthorized, 200, requestBody);

    }*/
  /*  @Test
    public void successGetUser() {
        GetRequest requestBody = GetRequest.builder().build();
        getRequestWithParam(endpointGetUser, 200,"UserId","3926af7a-b00f-4be2-8256-2e66fc5ea66b");
       // Response response = getRequest(endpointGetUser, 200);
        // public Response getRequestWithParam(String endPoint, Integer responseCode, String paramName, String value) {
        //        Response response = RestAssured.given()
        //                .spec(specification)
        //                .when()
        //                .pathParam("UserId", value)
        //                //  .pathParam(paramName, id)
        //                .log().all()
        //                .get(endpointGetUser)
        //                .then().log().all()
        //                .extract().response();
        //        response.then().assertThat().statusCode(responseCode);
        //        return response;
    }*/
}
