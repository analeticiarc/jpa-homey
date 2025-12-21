package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class TipoPagamentoTest extends Teste {
    
    @Test
    public void testPersistTipoPagamento() {
        CartaoCredito cc = new CartaoCredito();
        
        cc.setNomeCliente("Maria Santos");
        cc.setBanco("Santander");
        cc.setAgencia("5678");
        cc.setConta("123456");
        
        cc.setNumeroCartao("4222222222222222");
        cc.setNomeCartao("MARIA SANTOS");
        cc.setCodigoSeguranca("789");
        cc.setDataVencimento("03/29");
        
        cc.setTaxaCredito(new BigDecimal("4.00"));
        cc.setParcelamento(12);
        
        em.persist(cc);
        em.flush();
        
        assertNotNull(cc.getId());
    }
    
    @Test
    public void testFindTipoPagamento() {
        TipoPagamento tp = em.find(CartaoCredito.class, 2L);
        
        assertNotNull(tp);
        assertEquals("Nathalia Souza", tp.getNomeCliente());
        assertEquals("Banco do Brasil", tp.getBanco());
        assertEquals("1234", tp.getAgencia());
        assertEquals("567890", tp.getConta());
    }
    
}