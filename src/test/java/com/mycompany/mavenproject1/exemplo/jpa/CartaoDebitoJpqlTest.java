package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import jakarta.persistence.TypedQuery;

public class CartaoDebitoJpqlTest extends Teste {
    @Test
    public void testFindCartaoDebito() {

        TypedQuery<BigDecimal> q = em.createQuery(
            "SELECT MIN(t.valor) " +
            "FROM Transacao t " +
            "WHERE TYPE(t.tipoPagamento) = CartaoDebito",
            BigDecimal.class
        );

        BigDecimal valorMinimo = q.getSingleResult();

        assertNotNull(valorMinimo);
        assertEquals(new BigDecimal("8000.00"), valorMinimo);
    }

}
