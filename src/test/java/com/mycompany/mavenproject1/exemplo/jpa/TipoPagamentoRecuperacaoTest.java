package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Testes de recuperação, atualização e remoção para TipoPagamento.
 * Como TipoPagamento é abstrata, testamos através da classe concreta CartaoCredito.
 * 
 * Esta classe segue o padrão:
 * - testUpdateComMerge: desanexa a entidade com em.clear(), modifica e usa em.merge()
 * - testUpdateSemMerge: mantém a entidade gerenciada (managed) e apenas modifica
 * - testRemove: remove a entidade do banco de dados
 */
public class TipoPagamentoRecuperacaoTest extends Teste {
    
    
    @Test
    public void testUpdateTipoPagamentoComMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);
        
        em.clear(); // Desanexa a entidade do contexto de persistência
        
        // Modifica campos da classe base TipoPagamento
        cc.setBanco("Caixa Econômica");
        cc.setAgencia("9999");
        
        em.merge(cc); // Merge reanexa e sincroniza as mudanças
        em.flush();
        em.clear();
        
        // Verifica se as mudanças foram persistidas
        CartaoCredito atualizado = em.find(CartaoCredito.class, 2L);
        assertEquals("Caixa Econômica", atualizado.getBanco());
        assertEquals("9999", atualizado.getAgencia());
    }
    
    /**
     * Testa atualização de TipoPagamento sem usar merge.
     * 1. Busca a entidade (id=2)
     * 2. Modifica os campos (entidade permanece managed)
     * 3. JPA detecta automaticamente as mudanças no flush
     * 4. Verifica se foi atualizado no banco
     */
    @Test
    public void testUpdateTipoPagamentoSemMerge() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);
        
        // Modifica sem desanexar (entidade managed)
        // JPA detecta automaticamente as mudanças
        cc.setNomeCliente("Nathalia S. Souza");
        cc.setConta("999999");
        
        em.flush(); // Sincroniza mudanças com o banco
        em.clear();
        
        // Verifica se as mudanças foram persistidas
        CartaoCredito atualizado = em.find(CartaoCredito.class, 2L);
        assertEquals("Nathalia S. Souza", atualizado.getNomeCliente());
        assertEquals("999999", atualizado.getConta());
    }
    
    /**
     * Testa remoção de TipoPagamento.
     * 1. Busca a entidade (id=2)
     * 2. Remove com em.remove()
     * 3. Verifica se foi removida do banco (deve retornar null)
     */
    @Test
    public void testRemoveTipoPagamento() {
        CartaoCredito cc = em.find(CartaoCredito.class, 2L);
        assertNotNull(cc);
        
        em.remove(cc); // Remove a entidade
        em.flush();
        em.clear();
        
        // Verifica se foi removida (deve retornar null)
        CartaoCredito apagado = em.find(CartaoCredito.class, 2L);
        assertNull(apagado);
    }
}