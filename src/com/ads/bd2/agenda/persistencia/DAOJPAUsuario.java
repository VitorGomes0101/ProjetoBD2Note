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
	
	public List<Usuario> retrieveUsuario(String login, String senha){
		Usuario user = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(em != null){
			while(true){
				user = em.find(getDAOClass(), login);
				if(user.getSenha().equals(senha)){
					usuarios.add(user);
				}
			}
		}
		return usuarios;
	}
	
	public List<Usuario> retrieveUsuariosConhecidos(String idUsuario){
		return em.createQuery("FROM " + getDAOClass().getName()).getResultList();
		
	}
	
	public Long contarUsuariosSemLembretes(){
		return null;
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
            usuario = retrieve(usuario.getLogin());
            em.remove(usuario);
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
