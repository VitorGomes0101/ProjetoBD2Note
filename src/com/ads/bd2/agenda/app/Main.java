package com.ads.bd2.agenda.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;

public class Main {

	public static void main(String[] args) {
		
	long tempoInicialA = System.nanoTime();
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
	for(int i=0; i<1000; i++) {
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
	System.out.println("O tempo da operação A foi: "+ (System.nanoTime() - tempoInicialA)+" nanosegundos");

}
	
	
}