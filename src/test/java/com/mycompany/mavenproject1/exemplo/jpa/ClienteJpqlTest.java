/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class ClienteJpqlTest extends Teste {
    
    @Test
    public void testBuscarClientePorNome()
    {
        Cliente cliente = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.nome = :nome",
                Cliente.class
        )
        .setParameter("nome", "Fernanda Lima")
        .getSingleResult();
        
        assertNotNull(cliente);
        assertEquals("fernanda.lima@example.com", cliente.getEmail());
    }
    
    @Test
    public void testBuscarTodosCliente()
    {
        var clientes = em.createQuery(
                "SELECT c FROM Cliente c",
                Cliente.class
        ).getResultList();
        
        assertNotNull(clientes);
        assertEquals(3, clientes.size());
    }
    
    @Test
    public void testContarClientes()
    {
        Long total = em.createQuery(
                "SELECT COUNT(c) FROM Cliente c",
                Long.class
        ).getSingleResult();
        
        assertNotNull(total);
        assertEquals(Long.valueOf(3), total);
    }
    
    
}
