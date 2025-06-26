package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CatUpdateTest extends BaseCatServiceTest{

    @Test
    @Tag("Smoke")
    @DisplayName("updateCat modifies data correctly")
    void testUpdateCatModifiesDataCorrectly (){
        CatModel gatoModelo = defaultCat();
        ResponseContainer<CatResponse> addResponse = service.addCats(gatoModelo,null);
        ResponseContainer<CatModel> updateResponse = service.updateCat(66, gatoModelo, null);
        Assertions.assertNotNull(updateResponse);
        Assertions.assertEquals(200, updateResponse.getStatus());
        Assertions.assertNotNull(updateResponse.getData());
        CatModel resultado = updateResponse.getData();
        Assertions.assertEquals(66, resultado.getId());
        Assertions.assertEquals("Jhonny Walker", resultado.getName());
        Assertions.assertEquals(3, resultado.getAge());
        Assertions.assertEquals("Persian",resultado.getBreed());
        Assertions.assertEquals("2025-06-09T15:05:23.414Z",resultado.getDateJoined());
        Assertions.assertTrue(resultado.getVaccinated());
        Assertions.assertEquals(Arrays.asList("Calm"),resultado.getTemperament());
        Assertions.assertEquals("00000000-0000-0000-0000-000000000000",resultado.getStaffInCharge());
        Assertions.assertFalse(resultado.getIsAdopted());
    }
}
