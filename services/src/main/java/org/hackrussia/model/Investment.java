package org.hackrussia.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Document(collection = "investment")
public class Investment implements Serializable {

    @Id
    private String id;
    @DBRef
    private Client investor;
    @DBRef
    private Client borrower;
    private float risk;

    private boolean isAcceptInvestor;
    private boolean isAcceptBorrower;

    @PersistenceConstructor
    public Investment(Client investor, Client borrower, float risk) {
        super();
        this.investor = investor;
        this.borrower = borrower;
        this.risk = risk;
    }
}
