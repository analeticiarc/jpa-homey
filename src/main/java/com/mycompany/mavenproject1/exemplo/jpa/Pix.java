package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PIX")
public class Pix extends TipoPagamento {

    @Column(name = "CHAVE", nullable = false, length = 100)
    private String chave;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}

