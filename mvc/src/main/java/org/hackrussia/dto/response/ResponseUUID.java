package org.hackrussia.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.hackrussia.dto.Response;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
@Setter
public class ResponseUUID extends Response {
    private UUID uuid;

    public ResponseUUID(HttpStatus status, UUID uuid) {
        super(status);
        this.uuid = uuid;
    }
}
