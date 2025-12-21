package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TipoPagamentoTest extends Teste {

    @Test
    public void testPersistTipoPagamentoPix() {
        TipoPagamento tp = new Pix();
        tp.setNomeCliente("Cliente Teste");
        tp.setBanco("Inter");
        tp.setAgencia("0001");
        tp.setConta("123456");

        em.persist(tp);
        em.flush();

        assertNotNull(tp.getId());
    }


    @Test
    public void testFindTipoPagamentoPix() {
        TipoPagamento tp = em.find(TipoPagamento.class, 1L);
        assertNotNull(tp);
        assertEquals("Fernanda Lima", tp.getNomeCliente());
    }
}

