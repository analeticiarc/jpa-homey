package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import jakarta.persistence.TypedQuery;

public class TipoPagamentoJpqlTest extends Teste {
    @Test
    void testTipoPagamentoLikeSantander() {
        TypedQuery<TipoPagamento> q = em.createQuery(
            "SELECT t FROM TipoPagamento t WHERE t.banco LIKE '%Santander%'", TipoPagamento.class
        );
        List<TipoPagamento> resultado = q.getResultList();
        assertEquals(resultado.size(), 2);
    }

    @Test
    void testLower() {
        TypedQuery<TipoPagamento> q = em.createQuery(
            "SELECT LOWER(t.banco) FROM TipoPagamento t WHERE t.banco = :banco", TipoPagamento.class
        );
        q.setParameter("banco", "Santander");
        List<TipoPagamento> resultado = q.getResultList();
        assertEquals(resultado.size(), 2);
        assertEquals(resultado.get(0).getBanco(), "santander");
    }

    @Test
    void testUpper() {
        TypedQuery<TipoPagamento> q = em.createQuery(
            "SELECT UPPER(t.banco) FROM TipoPagamento t WHERE t.banco = :banco", TipoPagamento.class
        );
        q.setParameter("banco", "Santander");
        List<TipoPagamento> resultado = q.getResultList();
        assertEquals(resultado.size(), 2);
        assertEquals(resultado.get(0).getBanco(), "SANTANDER");
    }
}
