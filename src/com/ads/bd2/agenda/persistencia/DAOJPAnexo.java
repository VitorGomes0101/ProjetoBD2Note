package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Anexo;

public class DAOJPAnexo extends DAOJPA<Anexo> {

	public DAOJPAnexo(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Anexo> getDAOClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
