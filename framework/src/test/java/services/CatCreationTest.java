package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RequestResponseLogger;

public class CatCreationTest extends BaseCatServiceTest {

    @Test
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
}
