package org.hackrussia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientReq {
    private String login;
    private String password;
    private String dSignature;
    private String bGuid;
}
