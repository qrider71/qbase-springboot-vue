package com.mre.ping.service;

import com.mre.ping.rest.model.PingResponse;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
@Slf4j
public class PingService {

    public PingResponse ping(String message, int repeat) {
        final PingResponse pingResponse = new PingResponse();
        pingResponse.setTimestamp(OffsetDateTime.now());
        getHostname().map(JsonNullable::of).ifPresent(pingResponse::setHostname);
        pingResponse.setMessages(Collections.nCopies(repeat,message));
        log.info("Successfully received PING request with message " + message);
        return pingResponse;
    }

    private Optional<String> getHostname() {
        try {
            return Optional.ofNullable(InetAddress.getLocalHost().getCanonicalHostName());
        } catch (Exception e) {
            return  Optional.empty();
        }
    }
}
