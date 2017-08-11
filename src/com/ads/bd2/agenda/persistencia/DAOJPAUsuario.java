package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.Usuario;

public class DAOJPAUsuario extends DAOJPA<Usuario> {

	public DAOJPAUsuario(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Usuario> getDAOClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}
	public Usuario retrieve(String login) {
		Usuario objeto = null;
		if (em != null) {
			objeto = (Usuario) em.find(getDAOClass(),login);
		}
		return objeto;
	}

}
