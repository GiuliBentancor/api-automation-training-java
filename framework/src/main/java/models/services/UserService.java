package models.services;
import java.util.Map;

import base.ServiceBase;
import models.requests.UserModel;
import models.responses.ResponseContainer;
import models.responses.UserResponse;

public class UserService extends ServiceBase{
    public UserService() {
        super("/api/auth");
    }

    public ResponseContainer<UserResponse> addUser(UserModel model, Map<String, String> headers) {
        return this.post(this.url + "/register", model, headers, UserResponse.class);
    }

    public ResponseContainer<UserResponse> login(UserModel model, Map<String, String> headers) {
        return this.post(this.url + "/login", model, headers, UserResponse.class);
    }

    public ResponseContainer<UserResponse> refreshToken(String token, Map<String, String> headers) {
        return this.post(this.url + "/refresh", Map.of("refreshToken", token), headers, UserResponse.class);
    }
}
