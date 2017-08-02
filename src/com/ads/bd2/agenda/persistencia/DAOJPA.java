package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOJPA<O> {
	//em suas apps sempre crie esta factory somente uma vez, pois eh custoso cria-la	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2note");

	EntityManager em = null;

	public DAOJPA (EntityManager em) {
		this.em = em;
	}

	public static EntityManager createAndInitEntityManager() {
		if (emf != null) {
			return emf.createEntityManager();
		}
		return null;
	}

	public static void closeEntityManagerFactory() { 
		if (emf != null && emf.isOpen()) {
			emf.close();
			emf = null;
		}
	}

	public void closeEntityManager() {
		if (em != null && em.isOpen()) {
			em.close();
			em = null;
		}
	}


	public void create(O objeto) {
		if (em != null) {
			em.persist(objeto);
		}
	}

	public O retrieve(Long id) {
		O objeto = null;
		if (em != null) {
			objeto = (O) em.find(getDAOClass(),id);
		}
		return objeto;
	}

	public void update(O objeto) {
		//TODO
	}

	public void delete(O objeto) {
		//TODO
	}

	public abstract Class<O> getDAOClass();

}
