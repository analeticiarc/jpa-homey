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

public class ClienteSegundaEntregaTeste extends Teste {
    
    @Test
    public void testUpdateClienteComMerge()
    {
        Cliente c = em.find(Cliente.class, 2L);
        assertNotNull(c);
        
        em.clear();
        c.setCpf("11122233344");
        em.merge(c);
        em.flush();
        em.clear();
        
        Cliente atualizado = em.find(Cliente.class, 2L);
        assertEquals("11122233344", atualizado.getCpf());
    }
    
    @Test
    public void testUpdateClienteSemMerge()
    {
        Cliente c = em.find(Cliente.class, 2L);
        assertNotNull(c);
        
        c.setCpf("11122233344");
        
        em.flush();
        
        em.clear();
        
        Cliente atualizado = em.find(Cliente.class, 2L);
        assertEquals("11122233344", atualizado.getCpf());
    }
    
    
    @Test
    public void testRemoveCliente()
    {
        Cliente c = em.find(Cliente.class, 4L);
        assertNotNull(c);
        
        em.remove(c);
        em.flush();
        em.clear();
        
        Cliente apagado = em.find(Cliente.class, 4L);
        assertNull(apagado);
    }
    
}
