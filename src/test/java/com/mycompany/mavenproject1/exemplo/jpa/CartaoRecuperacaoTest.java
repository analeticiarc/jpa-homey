package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Testes de recuperação, atualização e remoção para Cartao.
 * Como Cartao é abstrata, testamos através da classe concreta CartaoCredito.
 * 
 * Esta classe segue o padrão:
 * - testUpdateComMerge: desanexa a entidade com em.clear(), modifica e usa em.merge()
 * - testUpdateSemMerge: mantém a entidade gerenciada (managed) e apenas modifica
 * - testRemove: remove a entidade do banco de dados
 */
public class CartaoRecuperacaoTest extends Teste {
    
    /**
     * Testa atualização de Cartao usando merge.
     * 1. Busca a entidade (id=1)
     * 2. Desanexa com em.clear()
     * 3. Modifica os campos da classe Cartao
     * 4. Usa em.merge() para sincronizar as mudanças
     * 5. Verifica se foi atualizado no banco
     */
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
    
    /**
     * Testa atualização de Cartao sem usar merge.
     * 1. Busca a entidade (id=1)
     * 2. Modifica os campos (entidade permanece managed)
     * 3. JPA detecta automaticamente as mudanças no flush
     * 4. Verifica se foi atualizado no banco
     */
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
    
    /**
     * Testa remoção de Cartao.
     * 1. Busca a entidade (id=1)
     * 2. Remove com em.remove()
     * 3. Verifica se foi removida do banco (deve retornar null)
     */
    @Test
    public void testRemoveCartao() {
        CartaoCredito cartao = em.find(CartaoCredito.class, 1L);
        assertNotNull(cartao);
        
        em.remove(cartao); // Remove a entidade
        em.flush();
        em.clear();
        
        // Verifica se foi removida (deve retornar null)
        CartaoCredito apagado = em.find(CartaoCredito.class, 1L);
        assertNull(apagado);
    }
}
