package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TransacaoRecuperacaoTest extends Teste {

    @Test
    public void testUpdateTransacaoComMerge() {
        Transacao t = em.find(Transacao.class, 1L);
        assertNotNull(t);

        em.clear();
        t.setStatus("ESTORNADO");

        em.merge(t);
        em.flush();
        em.clear();

        Transacao atualizada = em.find(Transacao.class, 1L);
        assertEquals("ESTORNADO", atualizada.getStatus());
    }

    @Test
    public void testUpdateTransacaoSemMerge() {
        Transacao t = em.find(Transacao.class, 2L);
        assertNotNull(t);

        t.setTaxaPlataforma(new BigDecimal("150.00"));
        em.flush();
        em.clear();

        Transacao atualizada = em.find(Transacao.class, 2L);
        assertEquals(new BigDecimal("150.00"), atualizada.getTaxaPlataforma());
    }

    @Test
    public void testRemoveTransacao() {
        Transacao t = em.find(Transacao.class, 3L);
        assertNotNull(t);

        em.remove(t);
        em.flush();
        em.clear();

        Transacao apagada = em.find(Transacao.class, 3L);
        assertNull(apagada);
    }
}

