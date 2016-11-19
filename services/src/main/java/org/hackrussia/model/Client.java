package org.hackrussia.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Document(collection = "clients")
public class Client implements Serializable {
    @Id
    private String id;
    private String login;
    private String eSignature;
    private String bGuid;
    private String password;

    @PersistenceConstructor
    public Client(String login, String password, String bGuid, String eSignature) {
        super();
        this.eSignature = eSignature;
        this.password = password;
        this.bGuid = bGuid;
        this.login = login;
    }
}
