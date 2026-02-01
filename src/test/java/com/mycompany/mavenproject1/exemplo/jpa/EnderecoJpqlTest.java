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
       public void testBuscarEnderecoPorCidade() {
           var enderecos = em.createQuery(
                   "SELECT e FROM Endereco e WHERE e.cidade = :cidade",
                   Endereco.class
           )
           .setParameter("cidade", "Recife")
           .getResultList();

           assertNotNull(enderecos);
           assertEquals(3, enderecos.size());
       }

       // Buscar endereços cujo bairro contenha uma palavra (LIKE)
       @Test
       public void testBuscarEnderecoPorBairroLike() {
           var enderecos = em.createQuery(
                   "SELECT e FROM Endereco e WHERE e.bairro LIKE :bairro",
                   Endereco.class
           )
           .setParameter("bairro", "%Centro%")
           .getResultList();

           assertNotNull(enderecos);
           assertEquals(1, enderecos.size());
       }

       // Contar endereços por estado (COUNT)
       @Test
       public void testContarEnderecosPorEstado() {
           Long total = em.createQuery(
                   "SELECT COUNT(e) FROM Endereco e WHERE e.estado = :estado",
                   Long.class
           )
           .setParameter("estado", "PE")
           .getSingleResult();

           assertNotNull(total);
           assertEquals(Long.valueOf(5), total);
       }

       // Concatenar rua e número por id
       @Test
       public void testRuaENumeroPorId() {
           String concatenacao = em.createQuery(
                   "SELECT CONCAT(e.rua, ', ', e.numero) FROM Endereco e WHERE e.id = :id",
                   String.class
           )
           .setParameter("id", 1L)
           .getSingleResult();

           assertEquals("Rua das Flores, 123", concatenacao);
       }

       // Contar quantas ruas começam com "Rua"
       @Test
       public void testQuantasRuas() {
           Long totalRuas = em.createQuery(
                   "SELECT COUNT(e) FROM Endereco e " +
                   "WHERE LOWER(e.rua) LIKE 'rua%'",
                   Long.class
           )
           .getSingleResult();

           assertEquals(Long.valueOf(4), totalRuas);
       }

       // Remover espaços extras do ponto de referência
       @Test
       public void testTrimEndereco() {
           String referencia = em.createQuery(
                   "SELECT TRIM(e.pontoReferencia) FROM Endereco e WHERE e.id = :id",
                   String.class
           )
           .setParameter("id", 5L)
           .getSingleResult();

           assertEquals("Ao lado da igreja", referencia);
       }
    
    
}
