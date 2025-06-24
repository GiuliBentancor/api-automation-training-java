package services;

import org.junit.jupiter.api.BeforeEach;

import models.requests.UserModel;
import models.services.UserService;

public class BaseUserServiceTest {
    protected final UserService service = new UserService();

    protected UserModel defaultUser(){
        UserModel model = new UserModel();
        model.setUsername("bbb");
        model.setPassword("PassNueva");
        return model;
    }

}
