package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import jakarta.persistence.TypedQuery; 

public class TransacaoJpqlTest extends Teste {
    @Test
    public void testPegarMediaTransacao() {
        TypedQuery<Object[]> q = em.createQuery(
            "SELECT t.cliente.nome, AVG(t.valor) FROM Transacao t LEFT JOIN  WHERE t.cliente.id = :id", Object[].class
        );
        q.setParameter("id", 1L);
        List<Object[]> resultado = q.getResultList();
        Object[] row = resultado.get(0);
        String nome = (String)row[0];
        BigDecimal valorMedio = (BigDecimal)row[1];

        assertEquals(nome, "Fernanda Lima");
        assertEquals(valorMedio, new BigDecimal("1600.00"));
    }
}
