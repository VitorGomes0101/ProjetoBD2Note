package com.ads.bd2.agenda.app;

import java.sql.Date;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;

public class Teste {

	public static void main(String[] args) {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPAUsuario daoUsuario= new DAOJPAUsuario(em);
		
		//CRIANDO USUARIOS E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)
		for(int i=0; i<1000; i++) {
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson"+i+1);
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson"+i+"@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));
		
		daoUsuario.create(usuario);
		}
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoUsuario.closeEntityManager();
		System.out.println("O tempo da operação foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}

}
