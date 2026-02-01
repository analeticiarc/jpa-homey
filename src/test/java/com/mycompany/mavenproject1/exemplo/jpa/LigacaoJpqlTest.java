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
public class LigacaoJpqlTest extends Teste {


    @Test
    public void testBuscarLigacoesDoTipoAudio() {
        List<Ligacao> ligacoes = em.createQuery(
            "SELECT l FROM Ligacao l WHERE l.tipo = 'AUDIO'",
            Ligacao.class
        ).getResultList();

        assertNotNull(ligacoes);
        assertEquals(2, ligacoes.size()); // IDs 1 e 6
    }
    
    @Test
    public void testBuscarLigacoesEntreDatas() {
        List<Ligacao> ligacoes = em.createQuery(
            "SELECT l FROM Ligacao l WHERE l.data BETWEEN :ini AND :fim",
            Ligacao.class
        )
        .setParameter("ini", java.sql.Date.valueOf("2025-12-01"))
        .setParameter("fim", java.sql.Date.valueOf("2025-12-03"))
        .getResultList();

        assertNotNull(ligacoes);
        assertEquals(2, ligacoes.size()); // IDs 1 e 2
    }
    
    @Test
    public void testBuscarLigacoesOrdenadasPorHorario() {
        List<Ligacao> ligacoes = em.createQuery(
            "SELECT l FROM Ligacao l ORDER BY l.horario ASC",
            Ligacao.class
        ).getResultList();

        assertNotNull(ligacoes);
        assertTrue(ligacoes.size() >= 1);
    }





    
}
