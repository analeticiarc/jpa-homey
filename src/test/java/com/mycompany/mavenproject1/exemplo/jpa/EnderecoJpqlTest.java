/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class EnderecoJpqlTest extends Teste{
    //TODO: buscar enderecos por cidade
    @Test
    public void testBuscarEnrecoPorCidade()
    {
        var enderecos = em.createQuery(
                "SELECT e FROM Endereco e WHERE e.cidade = :cidade",
                Endereco.class
        )
        .setParameter("cidade", "Recife")
        .getResultList();
        
        assertNotNull(enderecos);
        assertEquals(3, enderecos.size());
    }
    //TODO: buscar enderecos cujo bairro contenha uma palavra(LIKE)
    @Test
    public void testBuscarEnderecoPorBairroLike()
    {
        var enderecos = em.createQuery(
                "SELECT e FROM Endereco e WHERE e.bairro LIKE :bairro",
                Endereco.class
        )
        .setParameter("bairro", "%Centro%")
        .getResultList();
        
        assertNotNull(enderecos);
        assertEquals(1, enderecos.size());
    }
    
    //TODO: Contar enderecos por estado(COUNT)
    @Test
    public void testContarEnderecosPorEstado()
    {
        Long total = em.createQuery(
                "select count(e) FROM Endereco e WHERE e.estado = :estado",
                Long.class
        )
        .setParameter("estado", "PE")
        .getSingleResult();
        
        assertNotNull(total);
        assertEquals(Long.valueOf(4), total);
    }
    
    
}
