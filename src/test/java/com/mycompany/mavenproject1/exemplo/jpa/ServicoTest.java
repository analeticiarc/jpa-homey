package com.mycompany.mavenproject1.exemplo.jpa;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import jakarta.persistence.TypedQuery;

public class ServicoTest extends Teste {
    @Test
    public void testPersistServico() {
        Prestador prestador = em.find(Prestador.class, 2L);

        Servico servico = new Servico();
        servico.setTitulo("Corte de Grama");
        servico.setDescricao("Serviço completo de jardinagem");
        servico.setPrecoBase(new BigDecimal("150.00"));
        servico.setDisponivel(true);
        servico.setPrestador(prestador);

        em.persist(servico);
        em.flush();

        assertNotNull(servico.getId());
        assertNotNull(servico.getDataCriacao());
    }

    @Test
    public void testFindServicoById() {
        Servico encontrado = em.find(Servico.class, 1L);
        assertNotNull(encontrado);
        assertEquals("Limpeza de Piscina", encontrado.getTitulo());
    }

}
