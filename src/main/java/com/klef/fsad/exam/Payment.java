package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private String status;

    public Payment() {}

    public Payment(String name, Date date, String status) {
        this.name = name;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + date + " " + status;
    }
}