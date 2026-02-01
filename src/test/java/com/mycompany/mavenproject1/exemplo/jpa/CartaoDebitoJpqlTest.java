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
        TypedQuery<Object[]> q = em.createQuery(
            "SELECT MIN(t.valor) FROM Transacao t WHERE t.tipoPagamento.TIPO = :tipo", Object[].class
        );
        q.setParameter("tipo", "DEBITO");
        List<Object[]> resultado = q.getResultList();
        Object[] row = resultado.get(0);
        BigDecimal valorMinimo = (BigDecimal)row[0];
        assertEquals(valorMinimo, new BigDecimal("8000.00"));
    }    
}
