package com.mycompany.mavenproject1.exemplo.jpa;

import org.junit.Assert;
import org.junit.Test;

public class PrestadorTest extends Teste {

    @Test
    public void inserirPrestador() {
        Prestador p = new Prestador();
        p.setNome("Maria Oliveira");
        p.setEmail("maria@example.com");
        p.setTelefone("81988888888");
        p.setCpf_cnpj("12345678000199");
        p.setResumo("Profissional experiente");
        p.setAvaliacao(4.5);

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        Assert.assertNotNull(p.getId());
    }

    @Test
    public void consultarPrestadorPorId() {
        Prestador p = em.find(Prestador.class, 1L);
        Assert.assertNotNull(p);
        Assert.assertEquals("12345678000199", p.getCpf_cnpj());
    }
}
