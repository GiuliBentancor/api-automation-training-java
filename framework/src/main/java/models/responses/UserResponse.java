package models.responses;

import models.requests.UserModel;

public class UserResponse {
    private String message;
    private String userId;
    private String accessToken;
    private String refreshToken;

    private UserModel user;

    public UserResponse(){}

    public String getMessage(){
        return message;
    }

    public String getUserId(){
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
