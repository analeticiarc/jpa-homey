package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MensagemRecuperacaoTest extends Teste {

    @Test
    public void testUpdateMensagemComMerge() {
        Mensagem m = em.find(Mensagem.class, 1L);
        assertNotNull(m);

        em.clear();
        m.setConteudo("Mensagem atualizada");

        em.merge(m);
        em.flush();
        em.clear();

        Mensagem atualizada = em.find(Mensagem.class, 1L);
        assertEquals("Mensagem atualizada", atualizada.getConteudo());
    }

    @Test
    public void testUpdateMensagemSemMerge() {
        Mensagem m = em.find(Mensagem.class, 2L);
        assertNotNull(m);

        m.setConteudo("Nova mensagem sem merge");
        em.flush();
        em.clear();

        Mensagem atualizada = em.find(Mensagem.class, 2L);
        assertEquals("Nova mensagem sem merge", atualizada.getConteudo());
    }

    @Test
    public void testRemoveMensagem() {
        Mensagem m = em.find(Mensagem.class, 2L);
        assertNotNull(m);

        em.remove(m);
        em.flush();
        em.clear();

        Mensagem apagada = em.find(Mensagem.class, 2L);
        assertNull(apagada);
    }
}

