package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CartaoCreditoRecuperacaoTest extends Teste {

    @Test
    public void testUpdateCartaoCreditoComMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);

        em.clear();
        cc.setParcelamento(10);

        em.merge(cc);
        em.flush();
        em.clear();

        CartaoCredito atualizado = em.find(CartaoCredito.class, 2L);
        assertEquals(Integer.valueOf(10), atualizado.getParcelamento());
    }

    @Test
    public void testUpdateCartaoCreditoSemMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);

        cc.setTaxaCredito(new BigDecimal("4.20"));
        em.flush();
        em.clear();

        CartaoCredito atualizado = em.find(CartaoCredito.class, 2L);
        assertEquals(new BigDecimal("4.20"), atualizado.getTaxaCredito());
    }

    @Test
    public void testRemoveCartaoCredito() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);

        em.remove(cc);
        em.flush();
        em.clear();

        CartaoCredito apagado = em.find(CartaoCredito.class, 2L);
        assertNull(apagado);
    }
}

