/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author GPADS
 */
public class MensagemJpqlTest extends Teste {
    @Test
    public void testBuscarLigacoesOrdenadasPorHorario() {
        List<Ligacao> ligacoes = em.createQuery(
            "SELECT l FROM Ligacao l ORDER BY l.horario ASC",
            Ligacao.class
        ).getResultList();

        assertNotNull(ligacoes);
        assertTrue(ligacoes.size() >= 1);
    }
    
    @Test
    public void testBuscarMensagensPorDestinatario() {
        List<Mensagem> mensagens = em.createQuery(
            "SELECT m FROM Mensagem m WHERE m.destinatario = :dest",
            Mensagem.class
        )
        .setParameter("dest", "João Silva")
        .getResultList();

        assertNotNull(mensagens);
        assertEquals(1, mensagens.size());
    }
    
    @Test
    public void testContarTotalDeMensagens() {
        Long total = em.createQuery(
            "SELECT COUNT(m) FROM Mensagem m",
            Long.class
        ).getSingleResult();

        assertNotNull(total);
        assertEquals(Long.valueOf(3), total);
    }

    
}
