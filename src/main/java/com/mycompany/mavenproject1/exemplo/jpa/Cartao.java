package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Cartao extends Pagamento {

    @Column(name = "NUMERO", nullable = false, length = 20)
    protected String numero;

    @Column(name = "NOME_TITULAR", nullable = false, length = 100)
    protected String nomeTitular;

    @Column(name = "VALIDADE", nullable = false, length = 7)
    protected String validade;

    @Column(name = "BANDEIRA", nullable = false, length = 30)
    protected String bandeira;

    // ===== GETTERS E SETTERS =====

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
