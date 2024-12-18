package com.waka.jpa.entity;

import com.waka.jpa.util.Status;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "vendors")
public class Vendors implements Serializable {

    @Id
    private int id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "business_email")
    private String businessEmail;

    @Column(name = "business_phone")
    private String businessPhone;

    @Column(name = "status")
    private Status status;


    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
