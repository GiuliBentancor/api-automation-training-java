package services;

import java.util.List;
import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
public class CatPerformanceTest extends BaseCatServiceTest {
    @Test
    @Tag("Performance")
    @DisplayName("GET /cats responds in under 1000ms")
    void getCatsRespondsUnderOneSecond(){
        ResponseContainer<List<CatModel>> response = service.getCats(null);

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertTrue(
                response.getResponseTime() < 1000,
                "Response time was " + response.getResponseTime()
        );
    }
    @Test
    @Tag("Performance")
    @DisplayName("POST /cats responds in under 1000ms")
    void createCatRespondsUnderOneSecond() {
        CatModel model = defaultCat();
        ResponseContainer<CatResponse> response = service.addCats(model, null);

        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertTrue(
                response.getResponseTime() < 1000,
                "Response time was " + response.getResponseTime()
        );
    }
    @Test
    @Tag("Performance")
    @DisplayName("GET /cats/{id} responds in under 1000ms")
    void getCatByIdRespondsUnderOneSecond() {
        CatModel model = defaultCat();
        ResponseContainer<CatResponse> created = service.addCats(model, null);
        Integer catId = created.getData().getId();

        ResponseContainer<CatModel> response = service.getCatById(catId, null);

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertTrue(
                response.getResponseTime() < 1000,
                "Response time was " + response.getResponseTime()
        );
    }
}
