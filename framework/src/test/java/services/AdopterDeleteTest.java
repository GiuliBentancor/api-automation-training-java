package services;

import models.requests.AdopterModel;
import models.responses.AdopterResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AdopterDeleteTest extends BaseAdopterServiceTest{

    @Test
    @Tag("Smoke")
    @DisplayName("Delete adopter eliminates object successfully")
    void testDeleteAdopterByIdSuccessfully(){
        AdopterModel model = defaultAdopter();
        ResponseContainer<AdopterResponse> addResponse = service.addAdopter(model, null);
        AdopterResponse adopter = addResponse.getData();
        ResponseContainer<Void> deleteResponse = service.deleteAdopterById(adopter.getId(), null);
        Assertions.assertNotNull(deleteResponse);
        Assertions.assertEquals(204,deleteResponse.getStatus());
    }
}
