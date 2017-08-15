package com.ads.bd2.agenda.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Anexo;
import com.ads.bd2.agenda.modelo.LatitudeLongitude;
import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.Local;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALatitudeLongitude;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;
import com.ads.bd2.agenda.persistencia.DAOJPAnexo;

public class MainD {
	
	private final static int quant = 100;

	public static void main(String[] args) {
		String c = create();
		String r = retrieve();
		//String u = update();
		//String d = delete();
		
		System.out.println(c);
		System.out.println(r);
		//System.out.println(u);
		//System.out.println(d);
	}
	
	private static String create() {	
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		DAOJPAUsuario daoUsuario= new DAOJPAUsuario(em);
		DAOJPALatitudeLongitude daoLatitudeLongitude = new DAOJPALatitudeLongitude(em);
		DAOJPAnexo daoAnexo = new DAOJPAnexo(em);
		
		//CRIANDO USUARIO E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)	
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson");
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));		
				
		//BUSCANDO USUARIO, CRIANDO LEMBRETES E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)
		Collection<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		Lembrete lembrete = new Lembrete();
		lembrete.setDataCriacao(new Date(System.currentTimeMillis()));
		lembrete.setTitulo("Lembrete 1");
		lembrete.setTexto("Texto escrito");
		lembrete.setPosicaoEntreLembretes(1);		
		lembrete.setUsuario(usuarios);

		//CRIANDO ANEXOS
		List<Anexo> anexos = new ArrayList<Anexo>();
		for (int j = 0; j < quant; j++) {
			
			Local anexo = new Local();
			LatitudeLongitude latitudeLongitude = new LatitudeLongitude();
			
			latitudeLongitude.setLatitude(new Random().nextDouble());
			latitudeLongitude.setLongitude(new Random().nextDouble());
			daoLatitudeLongitude.create(latitudeLongitude);
			
			anexo.setDescricao("Decri��o de numero" + j);
			anexo.setCep("58500-000");
			anexo.setCidade("Monteiro");
			anexo.setEstado("Paraiba");
			anexo.setPais("Brasil");
			anexo.setLatitudeLongitude(latitudeLongitude);
			anexo.setPosicaoNoLembrete(j);
			anexo.setLembrete(lembrete);
			
			daoAnexo.create(anexo);
			anexos.add(anexo);
		}
		
		lembrete.setAnexo(anexos);
		daoLembrete.create(lembrete);
		daoUsuario.create(usuario);
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoUsuario.closeEntityManager();
		daoLembrete.closeEntityManager();
		return ("O tempo da opera��o CREATE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String retrieve() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		
		
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação RETRIEVE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String update() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		
		
		
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
		
		
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação DELETE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}

}
