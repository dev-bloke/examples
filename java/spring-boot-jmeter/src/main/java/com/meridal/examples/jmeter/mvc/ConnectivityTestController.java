package com.meridal.examples.jmeter.mvc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Connectivity test REST controller.
 * This is only used to check that the service is visible to client code.
 * @author Martin Ingram
 */
@Tag(name = "Connectivity Test", description = "HTTP connectivity smoke test.")
@RestController
public class ConnectivityTestController {

    /**
     * Connectivity test GET endpoint.
     * @return Success message
     */
    @Operation(summary = "Get a simple text response from the service.")
    @GetMapping("/test/")
    public final String connectivityTestEndpoint() {
        return "The service is visible.";
    }
}