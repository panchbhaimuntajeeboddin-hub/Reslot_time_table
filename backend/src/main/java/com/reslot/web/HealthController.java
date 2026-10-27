package com.reslot.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.util.Map;

@RestController
@Tag(name = "Operations", description = "Health and operational endpoints")
public class HealthController {

    @GetMapping("/")
    @Operation(summary = "Root redirect to Swagger UI")
    public RedirectView root() {
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("/api/v1/ping")
    @Operation(summary = "Simple liveness check")
    public Map<String, Object> ping() {
        return Map.of("status", "ok", "timestamp", Instant.now().toString(), "service", "reslot-api");
    }
}
