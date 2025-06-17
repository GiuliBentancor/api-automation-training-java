package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import utils.RequestResponseLogger;

import java.util.HashMap;
import java.util.Map;

public class GetCatByIDTest extends BaseCatServiceTest {

    private Integer catId;

    @BeforeEach
    void createCat() {
        CatModel model = defaultCat();
        ResponseContainer<CatResponse> response = service.addCats(model, null);
        catId = response.getData().getId();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("getCatById returns expected data with an existing cat")
    void testGetCatByIdReturnsCorrectCat(){
        ResponseContainer<CatModel> response = service.getCatById(catId, null);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(catId, response.getData().getId());
    }

    @Tag("Smoke")
    @DisplayName("getCatById returns 404 when providing a non existing ID")
    @Test
    public void testGetCatByIdReturnsNotFound() {
        Integer catId = 99999;
        Map<String, String> headers = new HashMap<>();

        ResponseContainer<CatModel> response = service.getCatById(catId, headers);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(404, response.getStatus());
        Assertions.assertNull(response.getData());
    }
}
