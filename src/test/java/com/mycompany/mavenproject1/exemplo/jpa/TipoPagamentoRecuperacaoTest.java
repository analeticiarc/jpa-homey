package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;


public class TipoPagamentoRecuperacaoTest extends Teste {
    
    
    @Test
    public void testUpdateTipoPagamentoComMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 1L);
        assertNotNull(cc);
        
        em.clear(); 
        
        cc.setBanco("Caixa Econômica");
        cc.setAgencia("9999");
        
        em.merge(cc); 
        em.flush();
        em.clear();
        
        CartaoCredito atualizado = em.find(CartaoCredito.class, 1L);
        assertEquals("Caixa Econômica", atualizado.getBanco());
        assertEquals("9999", atualizado.getAgencia());
    }
    
    
    @Test
    public void testUpdateTipoPagamentoSemMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 1L);
        assertNotNull(cc);
        
        
        cc.setNomeCliente("Nathalia S. Souza");
        cc.setConta("999999");
        
        em.flush(); 
        em.clear();
        
        CartaoCredito atualizado = em.find(CartaoCredito.class, 1L);
        assertEquals("Nathalia S. Souza", atualizado.getNomeCliente());
        assertEquals("999999", atualizado.getConta());
    }
    
    
    @Test
    public void testRemoveTipoPagamento() {
        CartaoCredito cc = em.find(CartaoCredito.class, 5L);
        assertNotNull(cc);
        
        em.remove(cc); 
        em.flush();
        em.clear();
        
        CartaoCredito apagado = em.find(CartaoCredito.class, 5L);
        assertNull(apagado);
    }
}