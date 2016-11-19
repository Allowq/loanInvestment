package org.hackrussia.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistryData {
    private String login;
    private String password;
    private String bGuid;
    private String dSignature;
}