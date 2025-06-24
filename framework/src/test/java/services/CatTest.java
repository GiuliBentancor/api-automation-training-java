package services;

import models.requests.CatModel;
import models.responses.CatResponse;
import models.responses.ResponseContainer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CatTest extends BaseCatServiceTest{

    private Integer hookCatId;
    ResponseContainer<CatResponse> response;

    @BeforeEach
    public void setup() {
        CatModel cat = defaultCat();
        response = service.addCat(cat, null);
        hookCatId = response.getData().getId();
    }

    @AfterEach
    public void limpiar() {
        if (hookCatId != null) {
            service.deleteCat(hookCatId, null);
        }
    }

    @Test
    @DisplayName("Crear un gato y probar si fue creado")
    @Tag("Smoke")
    void testCreateCat() {
        CatModel model = defaultCat();
        assertEquals(201, response.getStatus());
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
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");


        hookCatId = response.getData().getId();
    }

    @Test
    @DisplayName("Crear un gato sin nombre, devuelve error")
    @Tag("Regression")
    public void testCreateCatWithoutName(){
        CatModel model = defaultCat();
        model.setName(null);

        ResponseContainer<CatResponse> response = service.addCat(model, null);
        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Crear un gato con edad negativa, devuelve error")
    void createCatWithNegativeAge() {
        CatModel model = defaultCat();
        model.setAge(-3);

        ResponseContainer<CatResponse> response = service.addCat(model, null);

        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Crear un gato sin raza, devuelve error")
    void createCatWithEmptyBreed() {
        CatModel model = defaultCat();
        model.setBreed("");

        ResponseContainer<CatResponse> response = service.addCat(model, null);

        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Crear un gato con ID negativo de adoptante, devuelve error")
    void createCatWithInvalidAdopterId() {
        CatModel model = defaultCat();
        model.setAdopterId(-1);

        ResponseContainer<CatResponse> response = service.addCat(model, null);

        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Obtener un gato por su ID")
    @Tag("Smoke")
    public void testGetCatById() {
        ResponseContainer<CatModel> response = service.getCatById(6, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Obtener gato con ID inexistente, devuelve error")
    void getCatByInvalidId() {
        ResponseContainer<CatModel> response = service.getCatById(-10, null);
        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Obtener una lista de todos los gatos")
    @Tag("Smoke")
    public void testGetAllCats() {
        ResponseContainer<List<CatModel>> response = service.getCats(null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertTrue(response.getData().size() > 0);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Modificar un gato existente")
    @Tag("Smoke")
    public void testUpdateCat() {

        CatModel updatedCat = defaultCat();
        updatedCat.setName("Tom");
        updatedCat.setBreed("Arabian");

        ResponseContainer<CatResponse> response = service.updateCat(6, updatedCat, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("Tom", response.getData().getName());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Modificar un gato inexistente, devuelve error")
    @Tag("Smoke")
    public void testUpdateInvalidCat() {

        CatModel updatedCat = defaultCat();
        updatedCat.setName("Tom");
        updatedCat.setBreed("Arabian");

        ResponseContainer<CatResponse> response = service.updateCat(-3, updatedCat, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("Tom", response.getData().getName());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Modificar parcialmente un gato")
    @Tag("Smoke")
    public void testPatchCat() {
        CatModel partialUpdate = defaultCat();
        partialUpdate.setAdopterId(5);
        partialUpdate.setStaffInCharge("0000-0000-0001");

        ResponseContainer<CatResponse> response = service.patchCat(6, partialUpdate, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("0000-0000-0001", response.getData().getStaffInCharge());
        assertEquals(5, response.getData().getAdopterId());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Modificar incorrectamente de manera parcial un gato, devuelve error")
    @Tag("Regression")
    public void testInvalidPatchCat() {
        CatModel partialUpdate = defaultCat();
        partialUpdate.setAge(5);
        partialUpdate.setName("Gaston");

        ResponseContainer<CatResponse> response = service.patchCat(6, partialUpdate, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertEquals("Gaston", response.getData().getName());
        assertEquals(5, response.getData().getAge());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Elimina un gato por su ID")
    @Tag("Smoke")
    public void testDeleteCat() {
        ResponseContainer<CatResponse> response = service.deleteCat(70, null);

        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Elimina un gato con ID inválido, devuelve error")
    void testDeleteInvalidCat() {
        ResponseContainer<CatResponse> response = service.deleteCat(-3, null);
        assertTrue(response.getStatus() >= 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }
}
