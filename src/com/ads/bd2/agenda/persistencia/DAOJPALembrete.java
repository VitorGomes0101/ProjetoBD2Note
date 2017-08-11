package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.Lembrete;

public class DAOJPALembrete extends DAOJPA<Lembrete> {

	public DAOJPALembrete(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Lembrete> getDAOClass() {
		// TODO Auto-generated method stub
		return Lembrete.class;
	}

}
