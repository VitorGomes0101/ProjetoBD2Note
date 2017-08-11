package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.NotificacaoLembrete;

public class DAOJPANotificacaoLembrete extends DAOJPA<NotificacaoLembrete> {

	public DAOJPANotificacaoLembrete(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<NotificacaoLembrete> getDAOClass() {
		// TODO Auto-generated method stub
		return NotificacaoLembrete.class;
	}

}
