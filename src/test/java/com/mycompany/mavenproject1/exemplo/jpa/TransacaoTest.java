package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TransacaoTest extends Teste {

    @Test
    public void testPersistTransacao() {
        Contrato contrato = em.find(Contrato.class, 1L);
        Cliente cliente = em.find(Cliente.class, 2L);
        TipoPagamento pagamento = em.find(TipoPagamento.class, 1L);

        Transacao t = new Transacao();
        t.setStatus("PAGO");
        t.setValor(new BigDecimal("800.00"));
        t.setTaxaPlataforma(new BigDecimal("40.00"));
        t.setContrato(contrato);
        t.setCliente(cliente);
        t.setTipoPagamento(pagamento);

        em.persist(t);
        em.flush();

        assertNotNull(t.getId());
    }

    @Test
    public void testFindTransacaoById() {
        Transacao t = em.find(Transacao.class, 1L);
        assertNotNull(t);
        assertEquals("PAGO", t.getStatus());
    }
}

