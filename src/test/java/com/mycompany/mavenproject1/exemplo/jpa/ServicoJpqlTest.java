/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class ServicoJpqlTest extends Teste {
        // TODO: Usa JOIN FETCH
    @Test
    public void testFetchContratos() {
        TypedQuery<Servico> q = em.createQuery(
            "SELECT s FROM Servico s JOIN FETCH s.contratos", Servico.class
        );
        List<Servico> resultado = q.getResultList();
        Servico s = resultado.get(0);
        assertEquals(s.getContratos().get(0).getValor_final(), new BigDecimal("800.00"));
    }

    @Test
    public void testSomaLeftJoinGroupByTotalValorContratos() {
        TypedQuery<Object[]> q = em.createQuery(
            "SELECT s.titulo, COALESCE(SUM(c.valor_final), 0) FROM Servico s LEFT JOIN s.contratos c WHERE s.id = :id GROUP BY s.titulo", Object[].class
        ).setParameter("id", 1L);
        List<Object[]> resultado = q.getResultList();
        Object[] row = resultado.get(0);
        String titulo = (String)row[0];
        BigDecimal valorFinal = (BigDecimal)row[1];
        assertEquals(titulo, "Limpeza de Piscina");
        assertEquals(valorFinal, new BigDecimal("1600.00")); // SOMA total de todos os contratos do serviço id 1
    }

    @Test
    public void testContratoMaisCaroServico() {
        TypedQuery<Object[]> q = em.createQuery(
            "SELECT s.titulo, c.valor_final FROM Servico s LEFT JOIN s.contratos c WHERE s.id = :id ORDER BY c.valor_final DESC", Object[].class
        ).setParameter("id", 2L);
        List<Object[]> resultado = q.getResultList();
        Object[] row = resultado.get(0);
        String titulo = (String)row[0];
        BigDecimal valorFinal = (BigDecimal)row[1];
        assertEquals(titulo, "Construção Civil");
        assertEquals(valorFinal, new BigDecimal("8000.00")); // Contrato mais caro do serviço id 2
    }


}
