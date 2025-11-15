package com.mycompany.mavenproject1.exemplo.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISC_USUARIO",
        discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOME", nullable = false, length = 100)
    protected String nome;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    protected String email;
    @Column(name = "USERNAME", nullable = false, unique = true, length = 30)
    protected String username;
    @Column(name = "SENHA", nullable = false, length = 255)
    protected String senha;
    @Column(name = "DT_NASCIMENTO", nullable = false)
    protected Date dataNascimento; 
    @Column(name = "TELEFONE", nullable = false, length = 20)
    protected String telefone;
    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;    
    
    @PrePersist
    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}