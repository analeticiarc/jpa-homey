/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.PrePersist;
/**
 *
 * @author 55819
 */

@Entity
@Table(name = "HISTORICO_PAGAMENTO")
public class HistoricoPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Pagamento pagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_ANTERIOR", nullable = false, length = 20)
    private StatusPagamento statusAnterior;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_ATUAL", nullable = false, length = 20)
    private StatusPagamento statusAtual;

    @Column(name = "DT_EVENTO")
    private Date dataEvento;

    @PrePersist
    public void setDataEvento() {
        this.dataEvento = new Date();
    }

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public StatusPagamento getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(StatusPagamento statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public StatusPagamento getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(StatusPagamento statusAtual) {
        this.statusAtual = statusAtual;
    }

    public Date getDataEvento() {
        return dataEvento;
    }
    
}
