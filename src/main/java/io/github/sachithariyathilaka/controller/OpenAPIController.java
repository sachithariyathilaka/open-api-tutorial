package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.resource.APIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller layer for the organized rest endpoints.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@RestController
@RequestMapping("/api/openapi")
public class OpenAPIController
{

    @Value("${swagger-server-url}")
    private String swaggerServerUrl;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUIPath;

    /**
     * Fetch swagger url endpoint.
     *
     * @return  the api response
     */
    @GetMapping("/get")
    public ResponseEntity<APIResponse<String>> test() {
        APIResponse<String> apiResponse = new APIResponse<>(200, "API is Working!", swaggerServerUrl + swaggerUIPath + "/index.html");
        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
    }
}
