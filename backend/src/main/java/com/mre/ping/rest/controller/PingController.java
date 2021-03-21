package com.mre.ping.rest.controller;

import com.mre.ping.rest.model.PingResponse;
import com.mre.ping.service.PingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class PingController implements PublicApi, ReactiveHealthIndicator {

    private static final String DEFAULT_MESSAGE = "PING";
    private static final int DEFAULT_REPEAT = 1;

    private final PingService pingService;

    @Override
    public ResponseEntity<PingResponse> ping(@Valid String message, @Min(0) @Valid Integer repeat) {
        return ResponseEntity.ok(pingService.ping(
                Optional.ofNullable(message).orElse(DEFAULT_MESSAGE),
                Optional.ofNullable(repeat).orElse(DEFAULT_REPEAT))
        );
    }

    @Override
    public Mono<Health> health() {
        return checkDownstreamServiceHealth().onErrorResume(
                ex -> Mono.just(new Health.Builder().down(ex).build())
        );
    }

    private Mono<Health> checkDownstreamServiceHealth() {
        log.info("Running health check");
        return Mono.just(new Health.Builder().up().withDetail("message","everything ok").build());
    }
}
