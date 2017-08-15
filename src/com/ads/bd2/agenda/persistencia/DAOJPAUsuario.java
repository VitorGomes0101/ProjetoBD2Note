package com.ads.bd2.agenda.persistencia;

import java.util.ArrayList;
import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> retrieveUsuario(String login, String senha){
		List<Usuario> usuarios = em.createQuery("SELECT * FROM usuario WHERE login = " + login + " senha = " + senha).getResultList();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> retrieveUsuariosConhecidos(String idUsuario){
		List<Integer> idLembrete = em.createQuery("SELECT id_lembrete FROM lembrete_usuario WHERE login_usuario = " + idUsuario).getResultList();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (Integer i : idLembrete) {
			usuarios.addAll(em.createQuery("SELECT u.* FROM usuario u, lembrete_usuario lu WHERE lu.id_lembrete = " + i).getResultList());
		}
		return usuarios;
		
	}
	
	public int contarUsuariosSemLembretes(){
		return em.createQuery("select count(*) from usuario where login not in (select login_usuario from lembrete_usuario)").getMaxResults();
	}
	
	public Usuario retrieve(String login) {
		Usuario objeto = null;
		if (em != null) {
			objeto = (Usuario) em.find(getDAOClass(),login);
		}
		return objeto;
	}
	
	public void delete(Usuario usuario){
		try {
			if(usuario!=null){
			    usuario = retrieve(usuario.getLogin());
			    if(usuario!=null && em!=null){
					em.remove(usuario);
			    }
			}
		} catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
		}
	}
	
	public void update(Usuario usuario){
		try {
			Usuario user = retrieve(usuario.getLogin());
			
			if(usuario.getNome() != null){
				user.setNome(usuario.getNome());
			}
			
			if(usuario.getEmail() != null){
				user.setEmail(usuario.getEmail());
			}
			
			if (usuario.getSenha() != null){
				user.setSenha(usuario.getSenha());
			}
			
			if (usuario.getDataNascimento() != null){
				user.setDataNascimento(usuario.getDataNascimento());
			}
            em.merge(user);
		} catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
   
		}
	}
}
