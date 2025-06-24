package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import models.requests.UserModel;
import models.responses.ResponseContainer;
import models.responses.UserResponse;

public class UserTest extends BaseUserServiceTest {

    ResponseContainer<UserResponse> response;

    @BeforeEach
    public void setup() {
        UserModel user = defaultUser();
        response = service.addUser(user, null);
    }

    @Test
    @DisplayName("Crear un usuario")
    @Tag("Smoke")
    public void testCreateUser() {
        assertEquals(201, response.getStatus());
        Assertions.assertNotNull(response.getData());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @DisplayName("Crear un usuario invalido, devuelve error")
    @Tag("Regression")
    public void testInvalidCreateUser() {
        UserModel user = new UserModel();
        response = service.addUser(user, null);
        assertEquals(201, response.getStatus());
        Assertions.assertNotNull(response.getData());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }


    @Test
    @Tag("Smoke")
    @DisplayName("Login correcto devuelve token")
    public void testLogin() {
        UserModel model = defaultUser();
        ResponseContainer<UserResponse> response = service.login(model, null);
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData().getAccessToken());
        assertNotNull(response.getData().getRefreshToken());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Login incorrecto, devuelve error")
    public void testInvalidLogin() {
        UserModel model = new UserModel();
        ResponseContainer<UserResponse> response = service.login(model, null);
        assertEquals(200, response.getStatus());
        assertNotNull(response.getData().getAccessToken());
        assertNotNull(response.getData().getRefreshToken());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Refresh token válido retorna token nuevo")
    void testRefreshToken() {
        UserModel model = defaultUser();
        ResponseContainer<UserResponse> loginResponse = service.login(model, null);
        assertEquals(200, loginResponse.getStatus());
        String refreshToken = loginResponse.getData().getRefreshToken();
        ResponseContainer<UserResponse> response = service.refreshToken(refreshToken, null);

        assertEquals(200, response.getStatus());
        assertNotNull(response.getData().getAccessToken());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }

    @Test
    @Tag("Regression")
    @DisplayName("Refresh con token inválido, devuelve error")
    void testInvalidRefreshToken() {
        ResponseContainer<UserResponse> response = service.refreshToken("tokenError", null);
        assertEquals(200, response.getStatus());
        assertTrue(response.getResponseTime() < 1000, "El tiempo de respuesta fue excedido");
    }
}
