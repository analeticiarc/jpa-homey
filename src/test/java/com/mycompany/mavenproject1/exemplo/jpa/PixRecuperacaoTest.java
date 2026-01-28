package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PixRecuperacaoTest extends Teste {

    @Test
    public void testUpdatePixComMerge() {
        Pix pix = em.find(Pix.class, 2L);
        assertNotNull(pix);

        em.clear();
        pix.setChave("nova-chave@pix.com");

        em.merge(pix);
        em.flush();
        em.clear();

        Pix atualizado = em.find(Pix.class, 2L);
        assertEquals("nova-chave@pix.com", atualizado.getChave());
    }

    @Test
    public void testUpdatePixSemMerge() {
        Pix pix = em.find(Pix.class, 2L);
        assertNotNull(pix);

        pix.setBanco("Banco Atualizado");
        em.flush();
        em.clear();

        Pix atualizado = em.find(Pix.class, 2L);
        assertEquals("Banco Atualizado", atualizado.getBanco());
    }

    @Test
    public void testRemovePix() {
        Pix pix = em.find(Pix.class, 7L);
        assertNotNull(pix);

        em.remove(pix);
        em.flush();
        em.clear();

        Pix apagado = em.find(Pix.class, 7L);
        assertNull(apagado);
    }
}

