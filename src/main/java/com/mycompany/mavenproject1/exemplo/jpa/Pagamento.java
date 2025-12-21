package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PAGAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
    name = "DTYPE",
    discriminatorType = DiscriminatorType.STRING,
    length = 20
)
public abstract class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR", nullable = false, precision = 10, scale = 2)
    protected BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    protected StatusPagamento status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_CRIACAO", nullable = false, updatable = false)
    protected Date dataCriacao;



    @PrePersist
    protected void prePersist() {
        this.dataCriacao = new Date();
        this.status = StatusPagamento.PENDENTE;
    }

    /* ===== Métodos de domínio ===== */

    public void aprovar() {
        this.status = StatusPagamento.APROVADO;
    }

    public void recusar() {
        this.status = StatusPagamento.RECUSADO;
    }

    public void estornar() {
        this.status = StatusPagamento.ESTORNADO;
    }

    /* ===== Getters e setters ===== */

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }


}
