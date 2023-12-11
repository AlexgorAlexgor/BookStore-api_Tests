package tests;

import io.restassured.response.Response;

public class UserAPI extends BaseTest {
//public UserAPI(String token) {
//        super(token);
//    }
    public Response getUser(String valueUserId) {
//        String endpoint = "/Account/v1/User/{UserId}";
      return getRequestWithParam(endpointGetUser, 200, "UserId", valueUserId);
  }
//
  public Response deleteUser(String valueUserId) {
//        String endpoint = "/Account/v1/User/{UserId}";
      return deleteRequest(endpointGetUser, 204, valueUserId);
    }

}
