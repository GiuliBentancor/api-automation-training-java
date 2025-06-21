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
        AdopterModel modelo = defaultAdopter();
        RequestResponseLogger.logRequest(modelo);
        ResponseContainer<AdopterResponse> response = service.addAdopter(modelo, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(201, response.getStatus());

        createdAdopterId = response.getData().getId();
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(modelo.getName(), response.getData().getName());
        Assertions.assertEquals(modelo.getLastName(), response.getData().getLastName());
        Assertions.assertEquals(modelo.getDateOfBirth(), response.getData().getDateOfBirth());
        Assertions.assertEquals(modelo.getPhone(), response.getData().getPhone());
        Assertions.assertEquals(modelo.getAddress(), response.getData().getAddress());
    }
}
