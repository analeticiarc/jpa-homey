/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;
import jakarta.persistence.*;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGRADOURO", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false, length = 10)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 100)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false, length = 100)
    private String bairro;

    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @Column(name = "CEP", nullable = false, length = 9)
    private String cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    // Getters e Setters
    public Long getId() { return id; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public Usuario getUsuario() {
        return usuario;
    }
    
    protected void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
