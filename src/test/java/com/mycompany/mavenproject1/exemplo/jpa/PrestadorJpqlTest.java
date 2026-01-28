/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.TypedQuery;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class PrestadorJpqlTest extends Teste {
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
        assertEquals(1, resultado.size());
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
        assertEquals(3, resultado.size());
    }
    
}
