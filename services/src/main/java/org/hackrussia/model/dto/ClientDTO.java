package org.hackrussia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.model.Proposition;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String id;
    private String login;
    private String eSignature;
    private String bGuid;
    private List<Proposition> propositions;
}
