package models.services;

import base.ServiceBase;
import models.requests.UserModel;
import models.responses.UserResponse;
import models.responses.ResponseContainer;

import java.util.List;
import java.util.Map;

public class UserService extends ServiceBase {
    public UserService() {
        super("/api/users");
    }

    public ResponseContainer<UserResponse> addUser(UserModel model, Map<String, String> headers) {
        return this.post(this.url, model, headers, UserResponse.class);
    }

    public ResponseContainer<UserModel> getUserById(Integer userId, Map<String, String> headers) {
        return this.getSingleObject(this.url + "/" + userId, headers, UserModel.class);
    }

    public ResponseContainer<List<UserModel>> getUsers(Map<String, String> headers) {
        return this.getListOfObjects(this.url, headers);
    }

    public ResponseContainer<UserModel> updateUser(Integer userId, UserModel model, Map<String, String> headers) {
        return this.put(this.url + "/" + userId, model, headers, UserModel.class);
    }

    public ResponseContainer<Void> deleteUserById(Integer userId, Map<String, String> headers) {
        return this.delete(this.url + "/" + userId, "", headers, Void.class);
    }

    public ResponseContainer<UserModel> patchUserById(Integer userId, UserModel partialUpdate, Map<String, String> headers) {
        return this.patch(this.url + "/" + userId, partialUpdate, headers, UserModel.class);
    }
}