package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "MENSAGEM")
@DiscriminatorValue("M")
@PrimaryKeyJoinColumn(name="ID_MENSAGEM", referencedColumnName = "ID")
public class Mensagem extends Comunicacao {

    @Column(name = "CONTEUDO", length = 500, nullable = true)
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
