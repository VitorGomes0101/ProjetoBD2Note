package com.ads.bd2.agenda.persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Lembrete> retrieveLembretes(List<Usuario> usuariosCompartilhando){
		List<Lembrete> lembretes = new ArrayList<Lembrete>();
		
		String q = "";
		if(usuariosCompartilhando.size()>0) {
			q ="SELECT id_lembrete FROM lembrete_usuario WHERE login_usuario LIKE '"+usuariosCompartilhando.get(0).getLogin()+"' ";
		}
		if(usuariosCompartilhando.size()>1) {
			for(int i=1;i<usuariosCompartilhando.size();i++) {
				q += "INTERSECT SELECT id_lembrete FROM lembrete_usuario WHERE login_usuario LIKE '"+usuariosCompartilhando.get(i).getLogin()+"' ";
			}
		}
		q+=";";
		
		Query query = em.createNativeQuery(q);
		List<Long> idlembretes = query.getResultList();
		for(Long i: idlembretes) {
			Lembrete lembrete = retrieve(i);
			lembretes.add(lembrete);
		}
		
			return lembretes;
	}
	
	//retorna todos os lembretes de idUsuario que possuem notificações a sarem feitas num dado intervalo de tempo
	public List<Lembrete> retrieveLembretes(Long idUsuario, Date dataHoraLembrarInicial, Date dataHoraLembraFinal){
		return null;
	}
	
}
