package org.hackrussia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Response;
import org.hackrussia.model.dto.ClientDTO;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClient extends Response {
    private ClientDTO data;

    public ResponseClient(UUID uuid, ClientDTO clientDTO, HttpStatus status) {
        super(uuid, status);
        this.data = clientDTO;
    }
}
