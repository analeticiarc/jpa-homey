package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class LigacaoTest extends Teste {

    @Test
    public void testPersistLigacao() {
        Ligacao l = new Ligacao();
        l.setRemetente("Cliente Teste");
        l.setDestinatario("Prestador Teste");
        l.setTipo("VIDEO");

        em.persist(l);
        em.flush();

        assertNotNull(l.getId());
    }

    

    @Test
    public void testFindLigacao() {
        Ligacao l = em.find(Ligacao.class, 1L);
        assertNotNull(l);
        assertEquals("AUDIO", l.getTipo());  
    }
}

