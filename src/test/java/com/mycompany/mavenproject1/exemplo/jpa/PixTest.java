package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class PixTest extends Teste {

    @Test
    public void testPersistPix() {
        Pix pix = new Pix();
        pix.setNomeCliente("Cliente Pix");
        pix.setBanco("Nubank");
        pix.setAgencia("0001");
        pix.setConta("987654");
        pix.setChave("cliente@pix.com");

        em.persist(pix);
        em.flush();

        assertNotNull(pix.getId());
    }


    @Test
    public void testFindPix() {
        Pix pix = em.find(Pix.class, 1L);
        assertNotNull(pix);
        assertEquals("fernanda.lima@pix.com", pix.getChave());
    }
}

