package com.ads.bd2.agenda.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.ModoNotificacao;
import com.ads.bd2.agenda.modelo.NotificacaoLembrete;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPANotificacaoLembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;

public class Main {

	public static void main(String[] args) {
		
		//System.out.println(operacaoA());//-OK->10000 Lembretes (para somente 1 Usuário)
		
		//System.out.println(operacaoB());//-OK->10000 Lembretes (compartilhados entre 2 Usuários, com 1 Notificação para cada Usuário)
		
		//System.out.println(operacaoC());//--->1 Lembrete de 1 Usuário com 10000 Anexos, um de cada tipo(estratégia de herança)
		
		//System.out.println(operacaoD());//--->1 Lembrete com 10000 Anexos do tipo Local (com 1LatitudeLongitude exclusiva para 
										  //--->cada, em tabela separada)
		
		//System.out.println(operacaoE());//--->1 Lembrete com 10000 Anexos do tipo Local (com 1LatitudeLongitude exclusiva para 
										  //--->cada, embedded)
	}

	public static String operacaoA() {
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
		for(int i=0; i<10000; i++) {
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
		return ("O tempo da operação A foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
		
	}
	
	private static String operacaoB() {
		long tempoInicial = System.nanoTime();		
		
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO	
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		DAOJPAUsuario daoUsuario= new DAOJPAUsuario(em);
		DAOJPANotificacaoLembrete daoNotificacao= new DAOJPANotificacaoLembrete(em);
		
		
		//CRIANDO 2 USUARIOS E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)	
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson");
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));		
		daoUsuario.create(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("vitor");
		usuario2.setNome("Vitor");
		usuario2.setSenha("123");
		usuario2.setEmail("vitor@gmail.com");
		usuario2.setDataNascimento(new Date(System.currentTimeMillis()));		
		daoUsuario.create(usuario2);
		
		Collection<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);usuarios.add(usuario2);
		
		//CRIANDO 2 NOTIFICAÇÕES, LEMBRETES E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTÂNCIA)				
		for(int i=0; i<10000; i++) {			
			NotificacaoLembrete nl1 = new NotificacaoLembrete();
			nl1.setDataHoraLembrar(new Date(System.currentTimeMillis()));
			nl1.setModo(ModoNotificacao.EMAIL);
			nl1.setUsuario(usuario);		
			
			NotificacaoLembrete nl2 = new NotificacaoLembrete();
			nl2.setDataHoraLembrar(new Date(System.currentTimeMillis()));
			nl2.setModo(ModoNotificacao.TELA);
			nl2.setUsuario(usuario2);	
			
			Lembrete lembrete = new Lembrete();
			lembrete.setDataCriacao(new Date(System.currentTimeMillis()));
			lembrete.setTitulo("Lembrete"+i+1);
			lembrete.setTexto("Esse é o texto de número "+i+1);
			lembrete.setPosicaoEntreLembretes(1);		
			lembrete.setUsuario(usuarios);
			
			nl1.setLembrete(lembrete);
			nl2.setLembrete(lembrete);
						
			daoLembrete.create(lembrete);
			daoNotificacao.create(nl1);
			daoNotificacao.create(nl2);
		}		
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();
		daoUsuario.closeEntityManager();
		daoNotificacao.closeEntityManager();
		return ("O tempo da operação B foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
		
	}
	
	private static String operacaoC() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static String operacaoD() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static String operacaoE() {
		// TODO Auto-generated method stub
		return null;
	}
}