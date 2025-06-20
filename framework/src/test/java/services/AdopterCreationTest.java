package services;

import models.requests.AdopterModel;
import models.responses.AdopterResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import utils.RequestResponseLogger;

@Tag("AdopterTests")
public class AdopterCreationTest extends BaseAdopterServiceTest {

    private Integer createdAdopterId;
    @Test
    @Tag("Smoke")
    @DisplayName("Create a new adopter returns expected data")
    void createNewAdopter() {
        AdopterModel model = defaultAdopter();
        RequestResponseLogger.logRequest(model);
        ResponseContainer<AdopterResponse> response = service.addAdopter(model, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(201, response.getStatus());

        createdAdopterId = response.getData().getId();
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(model.getName(), response.getData().getName());
        Assertions.assertEquals(model.getLastName(), response.getData().getLastName());
        Assertions.assertEquals(model.getDateOfBirth(), response.getData().getDateOfBirth());
        Assertions.assertEquals(model.getPhone(), response.getData().getPhone());
        Assertions.assertEquals(model.getAddress(), response.getData().getAddress());
    }
}
}
