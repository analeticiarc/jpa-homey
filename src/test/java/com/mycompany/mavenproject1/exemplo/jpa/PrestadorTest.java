package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrestadorTest extends Teste {
    @Test
    public void testPersistPrestador() {
        Prestador prestador = new Prestador();
        prestador.setNome("Honda Rousey");
        prestador.setCpf_cnpj("12345678912");
        prestador.setEmail("honda.rousey@exemplo.com");
        prestador.setDataNascimento(new Date(1987, Calendar.FEBRUARY, 1));
        prestador.setSenha("hondahonda");
        prestador.setTelefone("(99) 987654321");
        prestador.setUsername("hondarousey");

        em.persist(prestador);
        em.flush();
        assertNotNull(prestador.getId());
    }

    @Test
    public void testFindPrestadorById() {
        Prestador c = em.find(Prestador.class, 4L);
        assertNotNull(c);
        assertEquals("Brad Pitt", c.getNome());
    }
}
