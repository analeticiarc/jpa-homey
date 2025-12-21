package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class EnderecoTest extends Teste {

    @Test
    public void testPersistEndereco() {
        Endereco e = new Endereco();
        e.setRua("Rua Nova");
        e.setNumero("45");
        e.setBairro("Centro");
        e.setCidade("Recife");
        e.setEstado("PE");
        e.setCep("50000-000");

        em.persist(e);
        em.flush();

        assertNotNull(e.getId());
    }

    @Test
    public void testFindEnderecoById() {
        Endereco e = em.find(Endereco.class, 100L);
        assertNotNull(e);
        assertEquals("Rua das Flores", e.getRua());
    }
}

