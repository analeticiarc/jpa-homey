/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SERVICO")
public class Servico {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;
    @Column(name = "DESCRICAO", nullable = true, length = 255)
    private String descricao;
    @Column(name = "PRECO_BASE", precision = 10, scale = 2)
    private BigDecimal precoBase;
    @Column(name = "DISPONIVEL", nullable = false)
    private Boolean disponivel;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID") //qual valor precimos colocar no referencial de coluna?
    private Prestador prestador;
    
    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SERVICOS_CATEGORIAS", joinColumns = {
        @JoinColumn(name = "ID_SERVICO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORIA")
            })
    private List<Categoria> categorias;

    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;    
    
    @PrePersist
    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    
    public List<Contrato> getContratos() {
        return contratos;
    }

    public void addContrato(Contrato contrato) {
        if(this.contratos == null) {
            this.contratos = new ArrayList<>();
        }
        this.contratos.add(contrato);
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
}
