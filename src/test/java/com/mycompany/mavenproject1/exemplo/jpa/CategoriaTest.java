/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.FileInputStream;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CategoriaTest extends Teste {
    @Test
    public void testPersistCategoria() {
        Categoria c = new Categoria();
        c.setNome("Jardinagem");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        assertNotNull(c.getId());
    }

    @Test
    public void testFindCategoriaById() {
        Categoria c = em.find(Categoria.class, 1);
        assertNotNull(c);
        assertEquals("Limpeza", c.getNome());
    }
}
