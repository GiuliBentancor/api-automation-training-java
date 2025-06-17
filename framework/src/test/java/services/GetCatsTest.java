package services;

import models.requests.CatModel;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;


public class GetCatsTest extends BaseCatServiceTest{

    @Test
    void testGetCatsReturnsListOfCats() {
        ResponseContainer<List<CatModel>> response = service.getCats(null);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertNotNull(response.getData());
    }
}
