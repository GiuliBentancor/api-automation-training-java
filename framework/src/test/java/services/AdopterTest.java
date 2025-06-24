package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import models.requests.AdopterModel;
import models.responses.AdopterResponse;
import models.responses.ResponseContainer;
import models.services.AdopterService;

public class AdopterTest extends BaseAdopterServiceTest {

    private final AdopterService service = new AdopterService();
    
    private Integer HookAdopterId;

    @BeforeEach
    public void setup() {
        AdopterModel Adopter = defaultAdopter();
        ResponseContainer<AdopterResponse> response = service.addAdopter(Adopter, null);
        HookAdopterId = response.getData().getId();
    }

    @AfterEach
    public void limpiar() {
        if (HookAdopterId != null) {
            service.deleteAdopter(HookAdopterId, null);
        }
    }

    @Test
    @DisplayName("Crear un adoptante")
    @Tag("Smoke")
    public void testCreateAdopter() {
        AdopterModel model = defaultAdopter();
        ResponseContainer<AdopterResponse> response = service.addAdopter(model, null);
        assertEquals(201, response.getStatus());
        AdopterResponse responseModel = response.getData();

        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(model.getName(), responseModel.getName());
        Assertions.assertEquals(model.getLastName(), responseModel.getLastName());
        Assertions.assertEquals(model.getDateOfBirth(), responseModel.getDateOfBirth());
        Assertions.assertEquals(model.getPhone(), responseModel.getPhone());
        Assertions.assertEquals(model.getAddress(), responseModel.getAddress());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");

        HookAdopterId = response.getData().getId();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Obtener todos los adoptantes")
    public void testGetAllAdopters() {
        ResponseContainer<List<AdopterModel>> response = service.getAllAdopters(null);
        assertEquals(200, response.getStatus());
        assertTrue(response.getData().size() > 0);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Buscar adoptante por ID")
    public void testGetAdopterById() {
        ResponseContainer<AdopterModel> response = service.getAdopterById(1, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Eliminar adoptante por ID")
    public void testDeleteAdopter() {
        ResponseContainer<AdopterResponse> response = service.deleteAdopter(3, null);

        assertTrue(response.getStatus() < 400);
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }
}
