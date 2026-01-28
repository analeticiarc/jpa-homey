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
        assertNotNull(s.getContratos());
        assertEquals(s.getContratos().get(0).getValor_final(), new BigDecimal("800.00"));
    }
}
