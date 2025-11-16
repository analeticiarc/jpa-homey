package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest extends Teste {

    @Test
    public void inserirCliente() {
        Cliente c = new Cliente();
        c.setNome("Fulano de Tal");
        c.setEmail("fulano@example.com");
        c.setTelefone("81999999999");
        c.setCpf("12345678901");

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        Assert.assertNotNull(c.getId());
    }

    @Test
    public void consultarClientePorId() {
        Cliente c = em.find(Cliente.class, 1L);
        Assert.assertNotNull(c);
        Assert.assertEquals("12345678901", c.getCpf());
    }
}
