package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CREDITO")
public class CartaoCredito extends Cartao {

    @Column(name = "TAXA_CREDITO", precision = 10, scale = 2, nullable = true)
    private BigDecimal taxaCredito;

    @Column(name = "PARCELAMENTO", nullable = true)
    private Integer parcelamento;

    public BigDecimal getTaxaCredito() {
        return taxaCredito;
    }

    public void setTaxaCredito(BigDecimal taxaCredito) {
        this.taxaCredito = taxaCredito;
    }

    public Integer getParcelamento() {
        return parcelamento;
    }

    public void setParcelamento(Integer parcelamento) {
        this.parcelamento = parcelamento;
    }
}

