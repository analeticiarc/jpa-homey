package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "LIGACAO")
public class Ligacao extends Comunicacao {

    @Column(name = "DT_INICIO")
    private Date dataInicio;

    @Column(name = "DT_FIM")
    private Date dataFim;

    @PrePersist
    public void iniciarLigacao() {
        this.dataInicio = new Date();
    }

    public void encerrarLigacao() {
        this.dataFim = new Date();
    }

    // getters
}
