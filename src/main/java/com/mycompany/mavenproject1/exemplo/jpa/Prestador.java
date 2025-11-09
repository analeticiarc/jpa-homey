/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRESTADOR")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID_PRESTADOR", referencedColumnName = "ID")
public class Prestador extends Usuario {
    @OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servico> servicos;

    public List<Servico> getServicos() {
        return servicos;
    }

    public void addServico(Servico servico) {
        if(this.servicos == null){
            this.servicos = new ArrayList<>();
        }
        this.servicos.add(servico);
    }
}

//falta contrato e categoria
