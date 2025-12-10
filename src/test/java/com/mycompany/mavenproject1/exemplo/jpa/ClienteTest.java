package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClienteTest extends Teste {
    @Test
    public void testPersistCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Fagundes");
        cliente.setCpf("12345678901");
        cliente.setEmail("maria.fagundes@exemplo.com");
        cliente.setDataNascimento(new Date(1988, Calendar.FEBRUARY, 12));
        cliente.setSenha("mariamaria");
        cliente.setTelefone("(81) 1234567890");
        cliente.setUsername("mariafagundes");

        em.persist(cliente);
        em.flush();
        assertNotNull(cliente.getId());
    }

    @Test
    public void testFindClienteById() {
        Cliente c = em.find(Cliente.class, 2L);
        assertNotNull(c);
        assertEquals("Fernanda Lima", c.getNome());
    }
}
