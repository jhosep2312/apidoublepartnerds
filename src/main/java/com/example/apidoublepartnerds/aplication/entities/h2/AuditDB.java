package com.example.apidoublepartnerds.aplication.entities.h2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "audit")
public class AuditDB {

    public AuditDB() {
    }

    public AuditDB(Timestamp initial_date, String method, String request, String error) {
        this.initial_date = initial_date;
        this.method = method;
        this.request = request;
        this.error = error;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Timestamp initial_date;
    String method;
    String request;
    String error;
}
