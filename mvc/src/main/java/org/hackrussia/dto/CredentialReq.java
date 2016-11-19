package org.hackrussia.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CredentialReq {
    private String login;
    private String password;
}