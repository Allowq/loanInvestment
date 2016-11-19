package org.hackrussia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Response;
import org.hackrussia.model.dto.PropositionDTO;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSearch extends Response {
    private Map<String, PropositionDTO> data;

    public ResponseSearch(UUID uuid, Map<String, PropositionDTO> map, HttpStatus status) {
        super(uuid, status);
        this.data = map;
    }
}
