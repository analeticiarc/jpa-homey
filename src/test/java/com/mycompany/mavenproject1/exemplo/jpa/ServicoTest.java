package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Date;

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

public class ServicoTest extends Teste {
    @Test
    public void testPersistServico() {
        Prestador prestador = em.find(Prestador.class, 2L);

        Servico servico = new Servico();
        servico.setTitulo("Corte de Grama");
        servico.setDescricao("Serviço completo de jardinagem");
        servico.setPrecoBase(new BigDecimal("150.00"));
        servico.setDisponivel(true);
        servico.setPrestador(prestador);

        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();

        assertNotNull(servico.getId());
        assertNotNull(servico.getDataCriacao());
    }

    @Test
    public void testFindServicoById() {
        Servico encontrado = em.find(Servico.class, 100L);
        assertNotNull(encontrado);
        assertEquals("Limpeza de Piscina", encontrado.getTitulo());
    }
}
