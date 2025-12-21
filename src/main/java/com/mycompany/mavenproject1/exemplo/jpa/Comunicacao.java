package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "COMUNICACAO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Comunicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CHAT", nullable = false)
    protected Chat chat;

    @ManyToOne
    @JoinColumn(name = "ID_REMETENTE", nullable = false)
    protected Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "ID_DESTINATARIO", nullable = false)
    protected Usuario destinatario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_COMUNICACAO", nullable = false)
    protected Date data;

    @PrePersist
    public void prePersist() {
        this.data = new Date();
    }

    // Getters
    public Long getId() { return id; }
    public Chat getChat() { return chat; }
    public Usuario getRemetente() { return remetente; }
    public Usuario getDestinatario() { return destinatario; }
    public Date getData() { return data; }
}
