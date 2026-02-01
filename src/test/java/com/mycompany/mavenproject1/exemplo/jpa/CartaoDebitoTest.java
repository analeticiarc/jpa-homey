package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CartaoDebitoTest extends Teste {

    @Test
    public void testPersistCartaoDebito() {
        CartaoDebito cd = new CartaoDebito();
        cd.setNomeCliente("Cliente Débito");
        cd.setBanco("Banco do Brasil");
        cd.setAgencia("4321");
        cd.setConta("111222");
        cd.setNumeroCartao("5500000000000004");
        cd.setNomeCartao("CLIENTE DEBITO");
        cd.setCodigoSeguranca("456");
        cd.setDataVencimento("11/28");
        cd.setTaxaDebito(new BigDecimal("1.80"));

        em.persist(cd);
        em.flush();

        assertNotNull(cd.getId());
    }


    @Test
    public void testFindCartaoDebito() {
        CartaoDebito cd = em.find(CartaoDebito.class, 3L);
        assertNotNull(cd);
        assertEquals("FERNANDA LIMA", cd.getNomeCartao());
    }
}
