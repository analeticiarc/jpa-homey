package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import jakarta.persistence.TypedQuery;

public class TipoPagamentoJpqlTest extends Teste {
    @Test
    public void testTipoPagamentoLikeSantander() {
        TypedQuery<TipoPagamento> q = em.createQuery(
            "SELECT t FROM TipoPagamento t WHERE t.banco LIKE '%Santander%'",
            TipoPagamento.class
        );

        List<TipoPagamento> resultado = q.getResultList();
        assertEquals(2, resultado.size());
    }

    @Test
    public void testLower() {
        TypedQuery<String> q = em.createQuery(
            "SELECT LOWER(t.banco) FROM TipoPagamento t WHERE t.banco LIKE '%Santander%'",
            String.class
        );

        List<String> resultado = q.getResultList();
        assertEquals(2, resultado.size());
        assertEquals("santander", resultado.get(0));
    }

    @Test
    public void testUpper() {
        TypedQuery<String> q = em.createQuery(
            "SELECT UPPER(t.banco) FROM TipoPagamento t WHERE t.banco LIKE '%Santander%'",
            String.class
        );

        List<String> resultado = q.getResultList();
        assertEquals(2, resultado.size());
        assertEquals("SANTANDER", resultado.get(0));
    }
}
