package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LigacaoRecuperacaoTest extends Teste {

    @Test
    public void testUpdateLigacaoComMerge() {
        Ligacao l = em.find(Ligacao.class, 1L);
        assertNotNull(l);

        em.clear();
        l.setTipo("VIDEO");

        em.merge(l);
        em.flush();
        em.clear();

        Ligacao atualizada = em.find(Ligacao.class, 1L);
        assertEquals("VIDEO", atualizada.getTipo());
    }

    @Test
    public void testUpdateLigacaoSemMerge() {
        Ligacao l = em.find(Ligacao.class, 2L);
        assertNotNull(l);

        l.setTipo("AUDIO");
        em.flush();
        em.clear();

        Ligacao atualizada = em.find(Ligacao.class, 2L);
        assertEquals("AUDIO", atualizada.getTipo());
    }

    @Test
    public void testRemoveLigacao() {
        Ligacao l = em.find(Ligacao.class, 2L);
        assertNotNull(l);

        em.remove(l);
        em.flush();
        em.clear();

        Ligacao apagada = em.find(Ligacao.class, 2L);
        assertNull(apagada);
    }
}

