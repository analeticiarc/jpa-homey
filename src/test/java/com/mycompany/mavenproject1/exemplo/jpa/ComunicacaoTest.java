/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author l.ribeiro.da.costa
 */
public class ComunicacaoTest extends Teste {
    
    @Test
    public void testPersistComunicacao() {
        Mensagem msg = new Mensagem();
        
        msg.setRemetente("Maria Santos");
        msg.setDestinatario("João Silva");
        msg.setConteudo("Olá, tudo bem? Preciso falar com você sobre o projeto.");
        
        em.persist(msg);
        em.flush();
        
        assertNotNull(msg.getId());
        assertNotNull(msg.getData());
        assertNotNull(msg.getHorario());
    }
    
    @Test
    public void testFindComunicacao() {
        Comunicacao com = em.find(Mensagem.class, 3L);
        
        assertNotNull(com);
        assertEquals("Fernanda Lima", com.getRemetente());
        assertEquals("João Silva", com.getDestinatario());
        assertNotNull(com.getData());
        assertNotNull(com.getHorario());
    }
    
}