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
            "SELECT t.cliente.nome, AVG(t.valor) FROM Transacao t " +
            "WHERE t.cliente.id = :id " +
            "GROUP BY t.cliente.nome",
            Object[].class
        );
        q.setParameter("id", 2L); // Fernanda Lima

        List<Object[]> resultado = q.getResultList();
        assertFalse("Nenhuma transação encontrada para o cliente", resultado.isEmpty());

        Object[] row = resultado.get(0);
        String nome = (String) row[0];

        Double valorDouble = (Double) row[1];
        BigDecimal valorMedio = BigDecimal.valueOf(valorDouble);

        assertEquals("Fernanda Lima", nome);
        assertEquals(new BigDecimal("2400.0"), valorMedio);
    }


}
