package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CartaoCreditoTest extends Teste {

    @Test
    public void testPersistCartaoCredito() {
        CartaoCredito cc = new CartaoCredito();
        cc.setNomeCliente("Cliente Crédito");
        cc.setBanco("Itaú");
        cc.setAgencia("1234");
        cc.setConta("999888");
        cc.setNumeroCartao("4111111111111111");
        cc.setNomeCartao("CLIENTE CREDITO");
        cc.setCodigoSeguranca("123");
        cc.setDataVencimento("12/29");
        cc.setTaxaCredito(new BigDecimal("3.50"));
        cc.setParcelamento(3);

        em.persist(cc);
        em.flush();

        assertNotNull(cc.getId());
    }


    @Test
    public void testFindCartaoCredito() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);
        assertEquals("NATHALIA SOUZA", cc.getNomeCartao());
        assertEquals(Integer.valueOf(6), cc.getParcelamento());
    }
}

