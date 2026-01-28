/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class ContratoJpqlTest extends Teste {
    
    //TODO: Buscar contratos por intervalo de datas(BETWEEN)
    @Test
    public void testBuscarContratosPorPeriodo() {
        var contratos = em.createQuery(
            "SELECT c FROM Contrato c WHERE c.data_inicio BETWEEN :ini AND :fim",
            Contrato.class
        )
        .setParameter("ini", java.sql.Date.valueOf("2025-10-01"))
        .setParameter("fim", java.sql.Date.valueOf("2025-10-31"))
        .getResultList();

        assertNotNull(contratos);
        assertEquals(2, contratos.size());
    }
    
    //TODO: buscar contratos com valor final acima de um limite
    //utilizando where com operador relacional
    @Test
    public void testBuscarContratosComValorMaiorQue() {
        var contratos = em.createQuery(
            "SELECT c FROM Contrato c WHERE c.valor_final > :valor",
            Contrato.class
        )
        .setParameter("valor", new BigDecimal("3000.00"))
        .getResultList();

        assertNotNull(contratos);
        assertEquals(2, contratos.size()); // 8000 e 4000
    }
    
    //TODO: Somar valores finais dos contratos de um serviços utilizando
    // join implicito +SUM
    @Test
    public void testSomarValorFinalPorServico() {
        BigDecimal total = em.createQuery(
            "SELECT SUM(c.valor_final) FROM Contrato c WHERE c.servico.id = :idServico",
            BigDecimal.class
        )
        .setParameter("idServico", 2L)
        .getSingleResult();

        assertNotNull(total);
        assertEquals(new BigDecimal("14400.00"), total);
    }



    
}
