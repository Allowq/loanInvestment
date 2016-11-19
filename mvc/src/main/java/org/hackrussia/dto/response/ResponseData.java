package org.hackrussia.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
@Setter
public class ResponseData extends ResponseUUID {
    private Object data;

    public ResponseData(HttpStatus status, UUID uuid, Object data) {
        super(status, uuid);
        this.data = data;
    }
}
