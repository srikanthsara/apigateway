package com.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RequestLoggingFilter
        implements GlobalFilter {

    public static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        log.info(
                "Incoming Request : {} {}",
                exchange.getRequest()
                        .getMethod(),
                exchange.getRequest()
                        .getURI());

        return chain.filter(exchange);
    }
}
