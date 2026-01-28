package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;


public class CartaoRecuperacaoTest extends Teste {
    
   
    @Test
    public void testUpdateCartaoComMerge() {
        CartaoCredito cartao = em.find(CartaoCredito.class, 1L);
        assertNotNull(cartao);
        
        em.clear(); // Desanexa a entidade do contexto de persistência
        
        // Modifica campos da classe Cartao
        cartao.setNomeCartao("J SILVA");
        cartao.setDataVencimento("12/30");
        
        em.merge(cartao); // Merge reanexa e sincroniza as mudanças
        em.flush();
        em.clear();
        
        // Verifica se as mudanças foram persistidas
        CartaoCredito atualizado = em.find(CartaoCredito.class, 1L);
        assertEquals("J SILVA", atualizado.getNomeCartao());
        assertEquals("12/30", atualizado.getDataVencimento());
    }
    
    
    @Test
    public void testUpdateCartaoSemMerge() {
        CartaoCredito cartao = em.find(CartaoCredito.class, 1L);
        assertNotNull(cartao);
        
        // Modifica sem desanexar (entidade managed)
        // JPA detecta automaticamente as mudanças
        cartao.setCodigoSeguranca("999");
        cartao.setNumeroCartao("4111111111119999");
        
        em.flush(); // Sincroniza mudanças com o banco
        em.clear();
        
        // Verifica se as mudanças foram persistidas
        CartaoCredito atualizado = em.find(CartaoCredito.class, 1L);
        assertEquals("999", atualizado.getCodigoSeguranca());
        assertEquals("4111111111119999", atualizado.getNumeroCartao());
    }
    
    
    @Test
    public void testRemoveCartao() {
        CartaoCredito cartao = em.find(CartaoCredito.class, 5L);
        assertNotNull(cartao);

        em.remove(cartao);
        em.flush();
        em.clear();

        CartaoCredito apagado = em.find(CartaoCredito.class, 5L);
        assertNull(apagado);
    }
}
