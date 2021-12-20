package com.example.gatewayservice.config;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouterValidator {

    private RouterValidator() {
    }

    // public Api
    public static final List<String> openApiEndpoints = List.of(
            "/users/register",
            "/users/login",
            "/api/v1/paiement/v3/api-docs",
            "/api/v1/commande/v3/api-docs"
    );

    public static final Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
            .stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
