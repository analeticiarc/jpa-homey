package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MENSAGEM")
public class Mensagem extends Comunicacao {

    @Column(name = "CONTEUDO", length = 500)
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
