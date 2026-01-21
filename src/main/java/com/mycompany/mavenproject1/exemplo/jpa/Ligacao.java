package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIGACAO")
@DiscriminatorValue(value = "L")
@PrimaryKeyJoinColumn(name="ID_LIGACAO", referencedColumnName = "ID")
public class Ligacao extends Comunicacao {

    @Column(name = "TIPO", length = 20)
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


