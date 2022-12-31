package com.example.proxy;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class FilterGlobal implements GlobalFilter {

    @Bean
    public GlobalFilter globalFilter() { return new FilterGlobal();}

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            var response = exchange.getResponse();

            if (exchange.getRequest().getMethod().equals(HttpMethod.GET)) {
                final var dataBuffer = response.bufferFactory()
                        .wrap("Get is not allowed".getBytes(StandardCharsets.UTF_8));

                response.writeWith(Mono.just(dataBuffer)).subscribe();
                exchange.mutate().response(response).build();
            }
        }));
    }
}
