package com.ads.bd2.agenda.persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.Usuario;

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
	
	public void update(Lembrete l) {
		if(l!=null && l.getIdLembrete()>0){
			Lembrete lBusca= retrieve(l.getIdLembrete());
			if(lBusca!=null && em!=null){
				if(l.getPosicaoEntreLembretes()>0) {
					lBusca.setPosicaoEntreLembretes(l.getPosicaoEntreLembretes());
				}
				if(l.getTexto()!=null) {
					lBusca.setTexto(l.getTexto());
				}
				if(l.getTitulo()!=null){
					lBusca.setTitulo(l.getTitulo());					
				}
				em.merge(lBusca);
			}
		}
	}

	public void delete(Lembrete l) {
		if(l!=null && l.getIdLembrete()>0){
			l= retrieve(l.getIdLembrete());
			if(l!=null && em!=null){
				em.remove(l);				
			}
		}
	}

	//retorna todos os lembretes compartilhados entre todos os usuariosCompartilhando
	public List<Lembrete> retrieveLembretes(ArrayList<Usuario> usuarios){
		int size = usuarios.size();
		
		//CABEÇALHO
		String jpql = "SELECT lembrete FROM Lembrete lembrete ";
		
		//INNER JOINS
		for(int i = 0; i<size; i++) {
			jpql+= "INNER JOIN lembrete.usuario u"+i+" ";
		}
		
		//WHERE
		//COMEÇO
		jpql+= "WHERE (u0 = :usuario0 ";
		if(size>1) {
			for(int i = 1; i<size; i++) {
				jpql+="AND u"+i+" = :usuario"+i+" "; 
			}	
		}
		//FIM
		jpql+=")";
		
		//CRIANDO QUERY
		TypedQuery<Lembrete> consulta = em.createQuery(jpql, Lembrete.class);
		
		//SETANDO PARAMENTROS
		for(int i = 0; i<size; i++) {
			consulta.setParameter("usuario"+i, usuarios.get(i));	
		}
		
		//OBTENDO RESULTADOS
		return consulta.getResultList();
	}
	
	//retorna todos os lembretes de idUsuario que possuem notificações a sarem feitas num dado intervalo de tempo
	public List<Lembrete> retrieveLembretes(String login, Date dataHoraLembrarInicial, Date dataHoraLembraFinal){
		return null;
	}
	
	
	
	
}
