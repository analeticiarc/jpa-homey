/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CategoriaTest extends Teste {

    @Test
    public void testPersistCategoria() {
        em.getTransaction().begin();
        Categoria c = new Categoria();
        c.setNome("Jardinagem");
        em.persist(c);
        em.getTransaction().commit();
        assertNotNull(c.getId());
    }

    @Test
    public void testFindCategoriaById() {
        Categoria c = em.find(Categoria.class, 2L);
        assertNotNull(c);
        assertEquals("Limpeza", c.getNome());
    }
}
