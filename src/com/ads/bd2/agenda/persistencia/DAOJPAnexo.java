package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Anexo;
import com.ads.bd2.agenda.modelo.Imagem;
import com.ads.bd2.agenda.modelo.Lembrete;

public class DAOJPAnexo extends DAOJPA<Anexo> {

	public DAOJPAnexo(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Anexo> getDAOClass() {
		// TODO Auto-generated method stub
		return Anexo.class;
	}
	
	public void update(Anexo a) {
		if(a!=null && a.getIdanexo()>0){
			Anexo aBusca= retrieve(a.getIdanexo());
			if(aBusca!=null && em!=null){
				if(a.getDescricao()!=null) {
					aBusca.setDescricao(a.getDescricao());
				}
				if(a.getPosicaoNoLembrete()>0) {
					aBusca.setPosicaoNoLembrete(a.getPosicaoNoLembrete());
				}					
				em.merge(aBusca);
			}
		}
	}

}
