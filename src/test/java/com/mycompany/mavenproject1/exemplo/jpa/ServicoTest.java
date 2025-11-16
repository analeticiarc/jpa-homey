package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
        Prestador prestador = new Prestador();
        prestador.setNome("João Prestador");
        em.getTransaction().begin();
        em.persist(prestador);
        em.getTransaction().commit();

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
    public void testFindServicoById() throws Exception {

        Prestador prestador = new Prestador();
        prestador.setNome("Maria Prestadora");
        prestador.setCpf_cnpj("00011122233");
        prestador.setResumo("Prestadora experiente");
        prestador.setAvaliacao(4.5);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nascimento = sdf.parse("1990-05-20");
        prestador.setDataNascimento(nascimento);

        prestador.setEmail("maria@example.com");
        prestador.setSenha("123456"); 
        prestador.setUsername("maria.prestadora");
        prestador.setTelefone("81999998888");

        em.getTransaction().begin();
        em.persist(prestador);
        em.getTransaction().commit();

        Servico servico = new Servico();
        servico.setTitulo("Limpeza de Piscina");
        servico.setDescricao("Limpeza completa com produtos");
        servico.setPrecoBase(new BigDecimal("200.00"));
        servico.setDisponivel(true);
        servico.setPrestador(prestador);

        prestador.addServico(servico);

        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();

        Servico encontrado = em.find(Servico.class, servico.getId());
        assertNotNull(encontrado);
        assertEquals("Limpeza de Piscina", encontrado.getTitulo());
        assertEquals(prestador.getId(), encontrado.getPrestador().getId());
    }

}
