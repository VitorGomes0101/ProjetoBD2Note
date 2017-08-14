package com.ads.bd2.agenda.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;

public class MainA {
	
 private final static int quant = 10000;  
 
	public static void main(String[] args) {
		String c = create();
		String r = retrieve();
		String u = update();
		String d = delete();
		
		System.out.println(c);
		System.out.println(r);
		System.out.println(u);
		System.out.println(d);
	}
	
	private static String create() {	
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		DAOJPAUsuario daoUsuario= new DAOJPAUsuario(em);
		
		//CRIANDO USUARIO E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)	
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson");
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));		
		daoUsuario.create(usuario);
		//em.getTransaction().commit();
		
		//BUSCANDO USUARIO, CRIANDO LEMBRETES E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)
		Usuario usuarioLembrete = daoUsuario.retrieve(usuario.getLogin());
		Collection<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuarioLembrete);
		for(int i=0; i<quant; i++) {
		Lembrete lembrete = new Lembrete();
		lembrete.setDataCriacao(new Date(System.currentTimeMillis()));
		lembrete.setTitulo("Lembrete"+i+1);
		lembrete.setTexto("Esse é o texto de número "+i+1);
		lembrete.setPosicaoEntreLembretes(1);		
		lembrete.setUsuario(usuarios);
		
		daoLembrete.create(lembrete);
		}
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();
		daoUsuario.closeEntityManager();
		return ("O tempo da operação CREATE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String retrieve() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER E INSTANCIANDO DAO DO LEMBRETE
		EntityManager em = DAOJPA.createAndInitEntityManager();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		List<Lembrete> lembretes = new ArrayList<Lembrete>();
		
		//BUSCANDO LEMBRETES
		for(long i=0;i<quant;i++) {
			Lembrete lembrete = daoLembrete.retrieve(i+1);
			lembretes.add(lembrete);
		}
		
		//FECHANDO ENTITY MANAGER
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação RETRIEVE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String update() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		
		//MUDANDO TÍTULO DOS LEMBRETES
		for(long i=0; i<quant; i++) {
			Lembrete lembrete = new Lembrete();
			lembrete.setIdLembrete(i+1);
			lembrete.setTitulo("Titulo atualizado");
			lembrete.setTexto("Texto atualizado");
			daoLembrete.update(lembrete);			
		}		
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação UPDATE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String delete() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
				
		//DELETANDO LEMBRETES
		for(long i=0;i<quant;i++) {
			Lembrete lembrete = new Lembrete();
			lembrete.setIdLembrete(i+1);
			daoLembrete.delete(lembrete);
		}
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação DELETE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}

}
