package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import org.junit.Test;

public class CartaoDebitoRecuperacaoTest extends Teste {

    @Test
    public void testUpdateCartaoDebitoComMerge() {
        CartaoDebito cd = em.find(CartaoDebito.class, 3L);
        assertNotNull(cd);

        em.clear();
        cd.setTaxaDebito(new BigDecimal("2.50"));

        em.merge(cd);
        em.flush();
        em.clear();

        CartaoDebito atualizado = em.find(CartaoDebito.class, 3L);
        assertEquals(new BigDecimal("2.50"), atualizado.getTaxaDebito());
    }

    @Test
    public void testUpdateCartaoDebitoSemMerge() {
        CartaoDebito cd = em.find(CartaoDebito.class, 3L);
        assertNotNull(cd);

        cd.setBanco("Banco Atualizado");
        em.flush();
        em.clear();

        CartaoDebito atualizado = em.find(CartaoDebito.class, 3L);
        assertEquals("Banco Atualizado", atualizado.getBanco());
    }

    @Test
    public void testRemoveCartaoDebito() {
        CartaoDebito cd = em.find(CartaoDebito.class, 6L); 
        assertNotNull(cd);
        em.remove(cd);
        em.flush();
        em.clear();
        CartaoDebito apagado = em.find(CartaoDebito.class, 6L);
        assertNull(apagado);
    }
}
