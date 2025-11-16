package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class Teste {

    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;


     @BeforeClass
     public static void setUpClass() {
         emf = Persistence.createEntityManagerFactory("exemplo_08");
         DbUnitUtil.inserirDados();  
     }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @After
    public void tearDown() {
        if (et != null && et.isActive()) {
            et.rollback();  
        }
        em.close();
    }
}
