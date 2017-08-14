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

}
