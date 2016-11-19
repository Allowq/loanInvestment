package org.hackrussia.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document(collection = "smart_contract")
public class SmartContract implements Serializable {

    @Id
    private String id;
    private double iSum;
    private double refund;
    private float percent;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date start;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date end;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date deadline;

    @PersistenceConstructor
    public SmartContract(double iSum, double refund, float percent, Date start, Date end, Date deadline) {
        this.iSum = iSum;
        this.refund = refund;
        this.percent = percent;
        this.start = start;
        this.end = end;
        this.deadline = deadline;
    }
}
