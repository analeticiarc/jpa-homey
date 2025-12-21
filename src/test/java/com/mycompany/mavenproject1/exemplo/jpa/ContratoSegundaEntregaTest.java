/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

/**
 *
 * @author GPADS
 */

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
public class ContratoSegundaEntregaTest extends Teste {
        @Test
    public void testUpdateContratoComMerge() {
        Contrato c = em.find(Contrato.class, 3L);
        assertNotNull(c);
        
        em.clear();
        c.setValor_final(new BigDecimal("750"));
        em.merge(c);
        em.flush();
        em.clear();

        Contrato atualizado = em.find(Contrato.class, 3L);
        assertEquals(new BigDecimal("750.00"), atualizado.getValor_final());
    }
    
    @Test
    public void testUpdateContratoSemMerge() {
        Contrato c = em.find(Contrato.class, 2L);
        assertNotNull(c);
        
        c.setValor_final(new BigDecimal("900"));

        em.flush();
        em.clear();

        Contrato atualizado = em.find(Contrato.class, 2L);
        assertEquals(new BigDecimal("900.00"), atualizado.getValor_final());
    }
    
    @Test
    public void testRemoveContrato() {
        Contrato c = em.find(Contrato.class, 3L);
        assertNotNull(c);

        em.remove(c);
        em.flush();
        em.clear();

        Contrato apagado = em.find(Contrato.class, 3L);
        assertNull(apagado);
    }

}
