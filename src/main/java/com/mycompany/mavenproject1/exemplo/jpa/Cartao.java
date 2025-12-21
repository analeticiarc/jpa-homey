package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARTAO")
public abstract class Cartao extends TipoPagamento {

    @Column(name = "NUMERO_CARTAO", length = 20)
    private String numeroCartao;

    @Column(name = "NOME_CARTAO", length = 100)
    private String nomeCartao;

    @Column(name = "CODIGO_SEGURANCA", length = 5)
    private String codigoSeguranca;

    @Column(name = "DATA_VENCIMENTO", length = 7)
    private String dataVencimento;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}

