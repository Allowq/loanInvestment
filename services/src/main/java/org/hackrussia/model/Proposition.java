package org.hackrussia.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "proposition")
public class Proposition {
    @Id
    private String id;
    private String title;
    private String disc;
    private double sum;
    private boolean isClosed;

    @PersistenceConstructor
    public Proposition(String title, String disc, double sum) {
        this.title = title;
        this.disc = disc;
        this.sum = sum;
    }
}
