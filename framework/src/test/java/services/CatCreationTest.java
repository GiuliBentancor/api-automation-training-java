package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RequestResponseLogger;

@Tag("CatTests")
public class CatCreationTest extends BaseCatServiceTest {

    @Test
    @Tag("Smoke")
    @DisplayName("Create a new cat returns expected data")
    void createNewCat() {
        CatModel model = defaultCat();
        RequestResponseLogger.logRequest(model);
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        RequestResponseLogger.logResponse(response);
        
        Assertions.assertEquals(201, response.getStatus());

        CatResponse responseModel = response.getData();
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(model.getName(), responseModel.getName());
        Assertions.assertEquals(model.getAge(), responseModel.getAge());
        Assertions.assertEquals(model.getBreed(), responseModel.getBreed());
        Assertions.assertEquals(model.getDateJoined(), responseModel.getDateJoined());
        Assertions.assertEquals(model.getVaccinated(), responseModel.getVaccinated());
        Assertions.assertEquals(model.getTemperament(), responseModel.getTemperament());
        Assertions.assertEquals(model.getStaffInCharge(), responseModel.getStaffInCharge());
        Assertions.assertEquals(model.getIsAdopted(), responseModel.getIsAdopted());
        Assertions.assertNull(responseModel.getAdopterId());
    }
    @Test
    @Tag("Regression")
    @DisplayName("Fail to create cat without name")
    void failToCreateCatWithoutName() {
        CatModel model = defaultCat();
        model.setName(null); // campo requerido

        RequestResponseLogger.logRequest(model);
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    @Tag("Regression")
    @DisplayName("Fail to create cat with negative age")
    void failToCreateCatWithNegativeAge() {
        CatModel model = defaultCat();
        model.setAge(-3); // edad inválida

        RequestResponseLogger.logRequest(model);
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(400, response.getStatus());
    }
    @Test
    @Tag("Regression")
    @DisplayName("Fail to create cat with null temperament")
    void failToCreateCatWithNullTemperament() {
        CatModel model = defaultCat();
        model.setTemperament(null); // campo requerido

        RequestResponseLogger.logRequest(model);
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        RequestResponseLogger.logResponse(response);

        Assertions.assertEquals(400, response.getStatus());
    }
}
