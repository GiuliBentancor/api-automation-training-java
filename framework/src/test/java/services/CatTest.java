package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatTest extends BaseCatServiceTest{

    @Test
    @DisplayName("Crear un gato y probar si fue creado")
    void testCreateCat() {
        CatModel model = defaultCat();
        ResponseContainer<CatResponse> response = service.addCat(model, null);
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
        //Assertions.assertEquals(model.getAdopterId(), responseModel.getAdopterId());
    }

    @Test
    @DisplayName("Obtener un gato por su ID")
    public void testGetCatById() {
        ResponseContainer<CatModel> response = service.getCatById(6, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        System.out.println(response.getData());
    }

    @Test
    @DisplayName("Obtener una lista de todos los gatos")
    public void testGetAllCats() {
        ResponseContainer<List<CatModel>> response = service.getCats(null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertTrue(response.getData().size() > 0);
    }

    @Test
    @DisplayName("Modificar un gato existente")
    public void testUpdateCat() {

        CatModel updatedCat = defaultCat();
        updatedCat.setName("Tom");
        updatedCat.setBreed("Arabian");

        ResponseContainer<CatResponse> response = service.updateCat(6, updatedCat, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("Tom", response.getData().getName());
    }

    @Test
    @DisplayName("Modificar parcialmente un gato")
    public void testPatchCat() {
        CatModel partialUpdate = defaultCat();
        partialUpdate.setAge(5);

        ResponseContainer<CatResponse> response = service.patchCat(1, partialUpdate, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals(5, response.getData().getAge());
    }

    @Test
    @DisplayName("Elimina un gato por su id")
    public void testDeleteCat() {
        ResponseContainer<CatResponse> response = service.deleteCat(1, null);

        assertEquals(200, response.getStatus());
    }
}
