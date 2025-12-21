package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EnderecoRecuperacaoTest extends Teste {

    @Test
    public void testUpdateEnderecoComMerge() {
        Endereco e = em.find(Endereco.class, 1L);
        assertNotNull(e);

        em.clear();
        e.setComplemento("Casa com portão azul");

        em.merge(e);
        em.flush();
        em.clear();

        Endereco atualizado = em.find(Endereco.class, 1L);
        assertEquals("Casa com portão azul", atualizado.getComplemento());
    }

    @Test
    public void testUpdateEnderecoSemMerge() {
        Endereco e = em.find(Endereco.class, 2L);
        assertNotNull(e);

        e.setBairro("Centro Atualizado");
        em.flush();
        em.clear();

        Endereco atualizado = em.find(Endereco.class, 2L);
        assertEquals("Centro Atualizado", atualizado.getBairro());
    }

    @Test
    public void testRemoveEndereco() {
        Endereco e = em.find(Endereco.class, 2L);
        assertNotNull(e);

        em.remove(e);
        em.flush();
        em.clear();

        Endereco apagado = em.find(Endereco.class, 2L);
        assertNull(apagado);
    }
}

