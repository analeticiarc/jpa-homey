/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author l.ribeiro.da.costa
 */
public class ComunicacaoRecuperacaoTest extends Teste {
    
    @Test
    public void testUpdateComunicacaoComMerge() {
        Mensagem msg = em.find(Mensagem.class, 3L);
        assertNotNull(msg);
        
        em.clear(); 
        
        msg.setRemetente("Novo Remetente");
        msg.setDestinatario("Novo Destinatario");
        
        em.merge(msg); 
        em.flush();
        em.clear();
        
        Mensagem atualizada = em.find(Mensagem.class, 3L);
        assertEquals("Novo Remetente", atualizada.getRemetente());
        assertEquals("Novo Destinatario", atualizada.getDestinatario());
    }
    
    @Test
    public void testUpdateComunicacaoSemMerge() {
        Mensagem msg = em.find(Mensagem.class, 4L);
        assertNotNull(msg);
        
        msg.setRemetente("Remetente Atualizado");
        msg.setDestinatario("Destinatario Atualizado");
        
        em.flush(); 
        em.clear();
        
        Mensagem atualizada = em.find(Mensagem.class, 4L);
        assertEquals("Remetente Atualizado", atualizada.getRemetente());
        assertEquals("Destinatario Atualizado", atualizada.getDestinatario());
    }
    
    @Test
    public void testRemoveComunicacao() {
        Mensagem msg = em.find(Mensagem.class, 5L);
        assertNotNull(msg);
        
        em.remove(msg);
        em.flush();
        em.clear();
        
        Mensagem apagada = em.find(Mensagem.class, 5L);
        assertNull(apagada);
    }
    
}
