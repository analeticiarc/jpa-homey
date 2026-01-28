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

public class CartaoCreditoTest extends Teste {

    @Test
    public void testPersistCartaoCredito() {
        CartaoCredito cc = new CartaoCredito();
        cc.setNomeCliente("Cliente Crédito");
        cc.setBanco("Itaú");
        cc.setAgencia("1234");
        cc.setConta("999888");
        cc.setNumeroCartao("4111111111111111");
        cc.setNomeCartao("CLIENTE CREDITO");
        cc.setCodigoSeguranca("123");
        cc.setDataVencimento("12/29");
        cc.setTaxaCredito(new BigDecimal("3.50"));
        cc.setParcelamento(3);

        em.persist(cc);
        em.flush();

        assertNotNull(cc.getId());
    }


    @Test
    public void testFindCartaoCredito() {
        CartaoCredito cc = em.find(CartaoCredito.class, 1L);
        assertNotNull(cc);
        assertEquals("JOAO SILVA", cc.getNomeCartao());
        assertEquals(Integer.valueOf(6), cc.getParcelamento());
    }

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
            "SELECT t FROM Transacao c WHERE t.tipoPagamento.id = :id", Transacao.class
        );
        q.setParameter("id", 8L);
        List<Transacao> resultado = q.getResultList();
        assertFalse("Transação deveria existir para o cartao pelo id", resultado.isEmpty());
        Transacao t = resultado.get(0);
        assertEquals(1, resultado.size()); // só há uma transação para esse cartão
        assertEquals("PAGO", t.getStatus());
        assertEquals(new BigDecimal("4000"), t.getValor());
    }


}

