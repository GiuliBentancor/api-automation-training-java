package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.responses.ResponseContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestResponseLogger {
    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLogger.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void logRequest(T request) {
        try {
            String requestJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
            logger.info("Request Body:\n{}", requestJson);
        } catch (Exception e) {
            logger.error("Error logging request", e);
        }
    }

    public static <T> void logResponse(ResponseContainer<T> response) {
        try {
            String responseJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
            logger.info("Response Body:\n{}", responseJson);
        } catch (Exception e) {
            logger.error("Error logging response", e);
        }
    }
} 