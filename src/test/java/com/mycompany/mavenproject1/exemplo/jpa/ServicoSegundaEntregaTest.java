package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ServicoSegundaEntregaTest extends Teste {
    
    @Test
    public void testUpdateServicoComMerge()
    {
        Servico s = em.find(Servico.class, 1L);
        assertNotNull(s);
        
        em.clear();
        s.setDescricao("Serviço atualizado com experiência em Limpeza e Jardinagem");
        
        em.merge(s);
        em.flush();
        em.clear();
        
        Servico atualizado = em.find(Servico.class, 1L);
        assertEquals("Serviço atualizado com experiência em Limpeza e Jardinagem", atualizado.getDescricao());
    }
    
    @Test
    public void testUpdateServicoSemMerge()
    {
        Servico s = em.find(Servico.class, 1L);
        assertNotNull(s);
        
        s.setDescricao("Serviço atualizado com experiência em Limpeza e Jardinagem");
        em.flush();
        em.clear();
        
        Servico atualizado = em.find(Servico.class, 1L);
        assertEquals("Serviço atualizado com experiência em Limpeza e Jardinagem", atualizado.getDescricao());
    }
    
    @Test
    public void testRemoveServico()
    {
        Servico s = em.find(Servico.class, 1L);
        assertNotNull(s);
        
        em.remove(s);
        em.flush();
        em.clear();

        Servico apagado = em.find(Servico.class, 1L);
        assertNull(apagado);
    }
    
}
