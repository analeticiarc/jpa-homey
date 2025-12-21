package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class MensagemTest extends Teste {

    @Test
    public void testPersistMensagem() {
        Mensagem m = new Mensagem();
        m.setRemetente("Cliente Teste");
        m.setDestinatario("Prestador Teste");
        m.setConteudo("Mensagem de teste");

        em.persist(m);
        em.flush();

        assertNotNull(m.getId());
    }


    @Test
    public void testFindMensagem() {
        Mensagem m = em.find(Mensagem.class, 1L);
        assertNotNull(m);
        assertEquals("Olá, gostaria de confirmar o horário do serviço.", m.getConteudo());
    }
}

