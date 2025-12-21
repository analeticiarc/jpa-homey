/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARTAO_CREDITO")
public class CartaoCredito extends Cartao {

    @Column(name = "LIMITE", nullable = false)
    private Double limite;

    @Column(name = "PARCELAS_MAX", nullable = false)
    private Integer parcelasMaximas;

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Integer getParcelasMaximas() {
        return parcelasMaximas;
    }

    public void setParcelasMaximas(Integer parcelasMaximas) {
        this.parcelasMaximas = parcelasMaximas;
    }
}
