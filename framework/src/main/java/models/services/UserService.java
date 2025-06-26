package models.services;

import base.ServiceBase;
import models.requests.UserModel;
import models.responses.UserResponse;
import models.responses.SessionResponse;
import models.responses.ResponseContainer;

import java.util.Map;

public class UserService extends ServiceBase {
    public UserService() {
        super("/api/auth");
    }

    public ResponseContainer<UserResponse> register(UserModel model, Map<String, String> headers) {
        return this.post(this.url + "/register", model, headers, UserResponse.class);
    }

    public ResponseContainer<SessionResponse> login(UserModel credentials, Map<String, String> headers) {
        return this.post(this.url + "/login", credentials, headers, SessionResponse.class);
    }
}