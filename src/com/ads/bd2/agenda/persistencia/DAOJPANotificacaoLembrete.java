package com.ads.bd2.agenda.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ads.bd2.agenda.modelo.Lembrete;
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
	
	//retorna todos as notificações de idUsuario confirmadas (ou não)
	public List<NotificacaoLembrete> retrieveNotificacoes(String login, boolean confirmadas){
		//CABEÇALHO
		String jpql = "SELECT notificacao FROM NotificacaoLembrete notificacao " +
				"INNER JOIN notificacao.usuario u "+
				"WHERE u.login = :login AND notificacao.confirmado = :confirmadas";
		
		//CRIANDO QUERY
		TypedQuery<NotificacaoLembrete> consulta = em.createQuery(jpql, NotificacaoLembrete.class);
		consulta.setParameter("login", login);
		consulta.setParameter("confirmadas", confirmadas);		
		
		//OBTENDO RESULTADOS
		return consulta.getResultList();
	}
}
