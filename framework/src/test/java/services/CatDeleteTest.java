package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CatDeleteTest extends BaseCatServiceTest{

    @Test
    @Tag("Smoke")
    @DisplayName("Delete cat eliminates object successfully")
    void testDeleteCatByIdSuccessfully(){
        CatModel gatoDefault = defaultCat();
        ResponseContainer<CatResponse> addResponse = service.addCats(gatoDefault,null);
        CatResponse gato = addResponse.getData();
        ResponseContainer<Void> deleteResponse = service.deleteCatById(gato.getId(), null);
        Assertions.assertNotNull(deleteResponse);
        Assertions.assertEquals(204,deleteResponse.getStatus());
        ResponseContainer<CatModel>getResponse = service.getCatById(gato.getId(),null);
        Assertions.assertEquals(404,getResponse.getStatus());
    }
}
