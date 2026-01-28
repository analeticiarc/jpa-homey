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
public class ComunicacaoJpqlTest extends Teste {
    @Test
    public void testBuscarTodasComunicacoesOrdenadasPorDataHora() {
        List<Comunicacao> lista = em.createQuery(
            "SELECT c FROM Comunicacao c ORDER BY c.data DESC, c.horario DESC",
            Comunicacao.class
        ).getResultList();

        assertNotNull(lista);
        assertTrue(lista.size() >= 1);
    }
    
    @Test
    public void testBuscarComunicacoesPorRemetente() {
        List<Comunicacao> lista = em.createQuery(
            "SELECT c FROM Comunicacao c WHERE c.remetente = :rem",
            Comunicacao.class
        )
        .setParameter("rem", "Nathalia Souza")
        .getResultList();

        assertNotNull(lista);
        assertEquals(2, lista.size()); // 1 ligação + 1 mensagem
    }
    
    @Test
    public void testBuscarSomenteMensagensViaClassePai() {
        List<Comunicacao> lista = em.createQuery(
            "SELECT c FROM Comunicacao c WHERE TYPE(c) = Mensagem",
            Comunicacao.class
        ).getResultList();

        assertNotNull(lista);
        assertEquals(3, lista.size()); // IDs 3, 4 e 5
    }



    
}
