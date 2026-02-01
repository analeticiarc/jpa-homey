/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

/**
 *
 * @author GPADS
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PrestadorSegundaEntregaTest extends Teste {
    
    @Test
    public void testUpdatePrestadorComMerge()
    {
        Prestador p = em.find(Prestador.class, 1L);
        assertNotNull(p);
        
        em.clear();
        p.setResumo("Prestador atualizado com experiência em Limpeza e Jardinagem");
        
        em.merge(p);
        em.flush();
        em.clear();
        
        Prestador atualizado = em.find(Prestador.class, 1L);
        assertEquals("Prestador atualizado com experiência em Limpeza e Jardinagem", atualizado.getResumo());
    }
    
    @Test
    public void testUpdatePrestadorSemMerge()
    {
        Prestador p = em.find(Prestador.class, 1L);
        assertNotNull(p);
        
        p.setResumo("Prestador atualizado com experiência em Limpeza e Jardinagem");
        em.flush();
        em.clear();
        
        Prestador atualizado = em.find(Prestador.class, 1L);
        assertEquals("Prestador atualizado com experiência em Limpeza e Jardinagem", atualizado.getResumo());
    }
    
    @Test
    public void testRemovePrestador()
    {
        Prestador p = em.find(Prestador.class, 6L);
        assertNotNull(p);
        
        em.remove(p);
        em.flush();
        em.clear();
        
        Prestador apagado = em.find(Prestador.class, 6L);
        assertNull(apagado);
    }
    
}
