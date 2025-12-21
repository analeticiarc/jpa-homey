package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class CartaoTest extends Teste {
    
    @Test
    public void testPersistCartao() {
        CartaoCredito cc = new CartaoCredito();
        
        cc.setNomeCliente("Pedro Oliveira");
        cc.setBanco("Bradesco");
        cc.setAgencia("3333");
        cc.setConta("777888");
        
        cc.setNumeroCartao("4333333333333333");
        cc.setNomeCartao("PEDRO OLIVEIRA");
        cc.setCodigoSeguranca("321");
        cc.setDataVencimento("09/28");
        
        cc.setTaxaCredito(new BigDecimal("2.50"));
        cc.setParcelamento(6);
        
        em.persist(cc);
        em.flush();
        
        assertNotNull(cc.getId());
        assertEquals("4333333333333333", cc.getNumeroCartao());
        assertEquals("PEDRO OLIVEIRA", cc.getNomeCartao());
    }
    
    @Test
    public void testFindCartao() {
        CartaoCredito cartao = em.find(CartaoCredito.class, 1L);
        
        assertNotNull(cartao);
        assertEquals("4111111111111111", cartao.getNumeroCartao());
        assertEquals("JOAO SILVA", cartao.getNomeCartao());
        assertEquals("123", cartao.getCodigoSeguranca());
        assertEquals("12/27", cartao.getDataVencimento());
    }
    
} 
