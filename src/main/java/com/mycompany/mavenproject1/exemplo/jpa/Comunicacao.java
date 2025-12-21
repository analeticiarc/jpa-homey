package com.mycompany.mavenproject1.exemplo.jpa;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMUNICACAO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Comunicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "HORARIO")
    private Time horario;

    @Column(name = "REMETENTE")
    private String remetente;

    @Column(name = "DESTINATARIO")
    private String destinatario;

    @PrePersist
    public void prePersist() {
        this.data = new Date();
        this.horario = new Time(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Time getHorario() {
        return horario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}

