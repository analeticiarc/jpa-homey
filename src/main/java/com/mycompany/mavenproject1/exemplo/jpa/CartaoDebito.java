package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEBITO")
public class CartaoDebito extends Cartao {

    @Column(name = "TAXA_DEBITO", precision = 10, scale = 2, nullable = true)
    private BigDecimal taxaDebito;

    public BigDecimal getTaxaDebito() {
        return taxaDebito;
    }

    public void setTaxaDebito(BigDecimal taxaDebito) {
        this.taxaDebito = taxaDebito;
    }
}

