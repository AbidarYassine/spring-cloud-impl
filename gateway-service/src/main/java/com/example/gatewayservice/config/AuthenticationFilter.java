package com.example.gatewayservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements GatewayFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
    private final JwtUtil jwtUtil;

    public AuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        if (RouterValidator.isSecured.test(request)) {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return response.setComplete();
            }
            final String token = jwtUtil.parseJwt(request.getHeaders().getOrEmpty("Authorization").get(0));
            if (jwtUtil.validateJwtToken(token)) {
                String username = jwtUtil.getUserNameFromJwtToken(token);
                logger.info("claims {}", username);
                exchange.getRequest().mutate().header("username", username).build();
            } else {
                response.setStatusCode(HttpStatus.BAD_REQUEST);
                return response.setComplete();
            }
        }
        return chain.filter(exchange);

    }
}
