/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CategoriaTest extends Teste {

    @Test
    public void testPersistCategoria() {
        Categoria c = new Categoria();
        c.setNome("Eletricista");
        em.persist(c);
        em.flush();
        assertNotNull(c.getId());
    }

    @Test
    public void testFindCategoriaById() {
        Categoria c = em.find(Categoria.class, 4L);
        assertNotNull(c);
        assertEquals("Cozinha", c.getNome());
    }
    
    @Test
    public void testUpdateCategoriaComMerge() {
        Categoria c = em.find(Categoria.class, 3L);
        assertNotNull(c);
        
        em.clear();
        c.setNome("Serviços de Jardinagem");
        em.merge(c);
        em.flush();
        em.clear();

        Categoria atualizado = em.find(Categoria.class, 3L);
        assertEquals("Serviços de Jardinagem", atualizado.getNome());
    }
    
    @Test
    public void testUpdateCategoriaSemMerge() {
        Categoria c = em.find(Categoria.class, 2L);
        assertNotNull(c);
        
        c.setNome("Serviços de Pedreiro");

        em.flush();
        em.clear();

        Categoria atualizado = em.find(Categoria.class, 2L);
        assertEquals("Serviços de Pedreiro", atualizado.getNome());
    }
    
    @Test
    public void testRemoveCategoria() {
        Categoria c = em.find(Categoria.class, 1L);
        assertNotNull(c);

        em.remove(c);
        em.flush();
        em.clear();

        Categoria apagado = em.find(Categoria.class, 1L);
        assertNull(apagado);
    }
}
