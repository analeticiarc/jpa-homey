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
    

}
