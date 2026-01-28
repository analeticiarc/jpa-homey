package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Test;

import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PrestadorTest extends Teste {
    @Test
    public void testPersistPrestador() {
        Prestador prestador = new Prestador();
        prestador.setNome("Honda Rousey");
        prestador.setCpf_cnpj("12345678912");
        prestador.setEmail("honda.rousey@exemplo.com");
        prestador.setDataNascimento(new Date(1987, Calendar.FEBRUARY, 1));
        prestador.setSenha("hondahonda");
        prestador.setTelefone("(99) 987654321");
        prestador.setUsername("hondarousey");

        em.persist(prestador);
        em.flush();
        assertNotNull(prestador.getId());
    }

    @Test
    public void testFindPrestadorById() {
        Prestador c = em.find(Prestador.class, 4L);
        assertNotNull(c);
        assertEquals("Brad Pitt", c.getNome());
    }

    // TODO: Usando o IS EMPTY
    @Test
    public void testPrestadorSemServicosCadastrados() {
        TypedQuery<Prestador> q = em.createQuery(
            "SELECT p FROM Prestador p WHERE p.servicos IS EMPTY", Prestador.class
        );
        List<Prestador> resultado = q.getResultList();
        assertFalse("Deveria existir prestador sem servicos cadastrados", resultado.isEmpty());
        assertEquals(2, resultado.size());
    }

    // TODO: Usando o IS NOT EMPTY
    @Test
    public void testPrestadorComServicosCadastrados() {
        TypedQuery<Prestador> q = em.createQuery(
            "SELECT p FROM Prestador p WHERE p.servicos IS NOT EMPTY", Prestador.class
        );
        List<Prestador> resultado = q.getResultList();
        assertFalse("Deveria existir prestador sem servicos cadastrados", resultado.isEmpty());
        assertEquals(2, resultado.size());
    }

    // TODO: Selecionando os serviços de um prestador
    @Test
    public void testServicosDoPrestador() {
        TypedQuery<Servico> q = em.createQuery(
            "SELECT p.servicos FROM Prestador p WHERE p.id = :id", Servico.class
        );
        q.setParameter("id", 1L);
        List<Servico> resultado = q.getResultList();
        assertFalse("Deveria existir servicos para esse prestador", resultado.isEmpty());
        assertEquals(3, resultado.size());
        var ids = List.of(1L, 2L, 4L);
        assertTrue(resultado.stream().map(Servico::getId).toList().containsAll(ids));
    }

    // TODO: Selecionando prestadores com mais de um servico
    @Test
    public void testPrestadorComMaisServicos() {
        TypedQuery<Servico> q = em.createQuery(
            "SELECT p.servicos FROM Prestador p WHERE SIZE(p.servicos) > 1", Servico.class
        );
        List<Servico> resultado = q.getResultList();
        assertEquals(2, resultado.size());
    }

    
}
