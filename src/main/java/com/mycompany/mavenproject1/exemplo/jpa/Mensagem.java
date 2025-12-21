package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "MENSAGEM")
public class Mensagem extends Comunicacao {

    @Column(name = "TEXTO", nullable = false, length = 500)
    private String texto;

    // getters e setters
}

