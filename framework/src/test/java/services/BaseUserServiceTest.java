package services;

import models.requests.UserModel;
import models.services.UserService;
import org.junit.jupiter.api.BeforeEach;

public class BaseUserServiceTest {
    protected final UserService service = new UserService();

    @BeforeEach
    public void setup() {
        //service.authenticate();
    }

    protected UserModel defaultUser() {
        UserModel model = new UserModel();
        model.setUsername("usuario");
        model.setPassword("contra");
        return model;
    }
}
