package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ContratoTest extends Teste {
    @Test
    public void testPersistContrato() {
        Contrato contrato = new Contrato();
        Servico servico = em.find(Servico.class, 1L);

        assertNotNull(servico);

        contrato.setData_inicio(new Date(2025, Calendar.JANUARY, 1));
        contrato.setData_fim(new Date(2025, Calendar.JANUARY, 10));
        contrato.setValor_final(new BigDecimal("1000.00"));

        contrato.setServico(servico);

        em.persist(contrato);
        em.flush();
        assertNotNull(contrato.getId());
    }

    @Test
    public void testFindContratoById() {
        Contrato c = em.find(Contrato.class, 1L);
        assertNotNull(c);
        assertEquals(Long.valueOf(1L), c.getId());
        assertEquals(new BigDecimal("800.00"), c.getValor_final());
        assertEquals(Long.valueOf(1L), c.getServico().getId());
    }
    

}
