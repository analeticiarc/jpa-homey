package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.Date;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHAT")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "ID_PRESTADOR", nullable = false)
    private Usuario prestador;

    @OneToOne
    @JoinColumn(name = "ID_CONTRATO", nullable = false, unique=true)
    private Contrato contrato;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Comunicacao> comunicacoes;

    @Column(name = "DT_CRIACAO")
    private Date dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = new Date();
    }

    // getters e setters
}
