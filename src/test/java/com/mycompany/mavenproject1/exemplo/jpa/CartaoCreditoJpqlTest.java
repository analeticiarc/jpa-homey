/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import jakarta.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author GPADS
 */
public class CartaoCreditoJpqlTest extends Teste {
        // TODO: SELECT simples
    @Test
    public void testSelecionarPorIdComJPQL() {
        TypedQuery<CartaoCredito> q = em.createQuery(
            "SELECT c FROM CartaoCredito c WHERE c.id = :id", CartaoCredito.class
        );
        q.setParameter("id", 8L);

        List<CartaoCredito> resultado = q.getResultList();
        assertFalse("Cartão do dataset deveria existir pelo id", resultado.isEmpty());
        CartaoCredito cc = resultado.get(0);
        assertEquals("CARLOS HENRIQUE", cc.getNomeCartao());
        assertEquals((Integer)6, cc.getParcelamento());
    }

    // TODO: Acessando entidades usando funcões do JPQL
    @Test
    public void testPegarTransacaoPeloCartaoUsado() {
        TypedQuery<Transacao> q = em.createQuery(
            "SELECT t FROM Transacao t WHERE t.tipoPagamento.id = :id", Transacao.class
        );
        q.setParameter("id", 8L);
        List<Transacao> resultado = q.getResultList();
        assertFalse("Transação deveria existir para o cartao pelo id", resultado.isEmpty());
        Transacao t = resultado.get(0);
        assertEquals(1, resultado.size());
        assertEquals("PAGO", t.getStatus());
        assertEquals(0, t.getValor().compareTo(new BigDecimal("4000")));

    }
    
}
