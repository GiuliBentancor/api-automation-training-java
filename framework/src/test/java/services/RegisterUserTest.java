package services;

import models.requests.UserModel;
import models.responses.UserResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RequestResponseLogger;

@Tag("UserTests")
public class RegisterUserTest extends BaseUserServiceTest {

    @Test
    @Tag("Smoke")
    @DisplayName("Create a new user returns expected data")
    void createNewUser() {
        UserModel model = defaultUser();
        RequestResponseLogger.logRequest(model);
        ResponseContainer<UserResponse> response = service.register(model, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(model.getUsername(), response.getData().getUsername());
    }
}
