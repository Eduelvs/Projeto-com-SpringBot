package br.edu.unifei.ecot13.trabalho;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class insert {
	public static void main(String[] args) {
		Humano h= new Humano();
		h.setNome("Finn");h.setHabilidadeFisica("Voar"); h.setIdade(20);
		Arma a= new Arma();
		a.setNome("Espada De Grama"); a.setTamanho(20);
		SeresVivos sv = new SeresVivos();
		sv.setNome("Princesa Jujuba");
		CidadelaAlemDoMultiverso c = new CidadelaAlemDoMultiverso();
		c.setEntidadeMorta("Enquiridio");
		Bolsa b = new Bolsa();
		b.setCapacidade(10);
		Encarocado e = new Encarocado();
		e.setNome("Princesa Caroço");
		EntidadeElementar ee = new EntidadeElementar();
		ee.setNome(sv.getNome());
		EntidadesCosmicas ec = new EntidadesCosmicas();
		ec.setNome("Litch");
		Governante g = new Governante();
		g.setNome(sv.getNome());
		Reino r = new Reino();
		r.setDono(g.getNome());
		Eventos ev = new Eventos();
		ev.setLocalidade(r.getNome());
		Magico m = new Magico();
		m.setEfeito("Lentidão");
		Mo mo = new Mo();
		mo.setNome("BMO");
		Objeto o = new Objeto();
		o.setNome("Espada");
		Pocao p = new Pocao();
		p.setNome("Poção Da Vida");
		PovoDoce pv = new PovoDoce();
		pv.setNome("Canelinha");
		PovoLimao pl = new PovoLimao();
		pl.setNome("Limão Grab");
		Vilas v = new Vilas();
		v.setNome("Vila Escura");
		
		
		
        EntityManagerFactory emf
        = Persistence.createEntityManagerFactory("horaaventura");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(r);
		em.persist(h);
		em.persist(a);
		em.persist(sv);
		em.persist(c);
		em.persist(b);
		em.persist(e);
		em.persist(ee);
		em.persist(ec);
		em.persist(g);
		em.persist(r);
		em.persist(ev);
		em.persist(m);
		em.persist(mo);
		em.persist(o);
		em.persist(p);
		em.persist(pv);
		em.persist(pl);
		em.persist(v);
		
        em.getTransaction().commit();
        em.close();
        emf.close();
		
	}
}