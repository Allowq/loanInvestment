package org.hackrussia.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RequestComplete<T> extends RequestData<T> {
    private UUID uuid;

    public RequestComplete(UUID uuid, T data) {
        super(data);
        this.uuid = uuid;
    }
}
