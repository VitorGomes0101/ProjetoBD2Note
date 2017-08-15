package com.ads.bd2.agenda.app;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.Anexo;
import com.ads.bd2.agenda.modelo.Imagem;
import com.ads.bd2.agenda.modelo.LatitudeLongitude;
import com.ads.bd2.agenda.modelo.Lembrete;
import com.ads.bd2.agenda.modelo.Local;
import com.ads.bd2.agenda.modelo.URL;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALatitudeLongitude;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;
import com.ads.bd2.agenda.persistencia.DAOJPAnexo;

public class MainC {
	private final static int quant = 33;  
 
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
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAOs
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		DAOJPAnexo daoAnexo = new DAOJPAnexo(em);	
		DAOJPALatitudeLongitude daoLagitude = new DAOJPALatitudeLongitude(em);
		DAOJPAUsuario daoUsuario = new DAOJPAUsuario(em);
		ArrayList<Anexo> anexos = new ArrayList<Anexo>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		//CRIANDO USUARIOS E INSERINDO DENTRO DA TRANSAÇÃO (PERSISTENCIA)	
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson");
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));	
		usuarios.add(usuario);
		daoUsuario.create(usuario);
		
		//CRIANDO LEMBRETE
		Lembrete l = new Lembrete();
		l.setPosicaoEntreLembretes(1);
		l.setTexto("Texto");
		l.setTitulo("Título");
		l.setDataCriacao(new Date(System.currentTimeMillis()));			
		l.setUsuario(usuarios);
		
		//CRIANDO LOCAIS
		for(int i=0;i<quant+1;i++) {	
			LatitudeLongitude lagitude = new LatitudeLongitude();
			lagitude.setLatitude(13.13*quant*(i+1));
			lagitude.setLongitude(16.16*quant*(i+1));
			daoLagitude.create(lagitude);			
			
			Local local = new Local();
			local.setCep("58500-000");
			local.setCidade("Monteiro");
			local.setEstado("Paraíba");
			local.setPais("Brasil");			
			local.setDescricao("Geoposição");
			local.setPosicaoNoLembrete(1);
			local.setLatitudeLongitude(lagitude);
			local.setLembrete(l);
			daoAnexo.create(local);
			anexos.add(local);
		}		

		//CRIANDO URLS
		for(int i=0;i<quant;i++) {			
			URL url = new URL();
			url.setUrl("www.google.com.br");
			url.setDescricao("Google");
			url.setPosicaoNoLembrete(1);
			url.setLembrete(l);
			daoAnexo.create(url);
			anexos.add(url);
		}
		
		//CRIANDO IMAGENS
		for(int i=0;i<quant;i++) {			
			Imagem imagem = new Imagem();
			imagem.setCaminhoSistemaArquivos("C:Minhas Imagens");
			imagem.setDescricao("LogoMarca");
			imagem.setPosicaoNoLembrete(1);
			imagem.setLembrete(l);
			daoAnexo.create(imagem);
			anexos.add(imagem);
		}		
		
		//SETANDO ANEXOS EM LEMBRETE E ADICIONANDO-O AO MANAGER
		l.setAnexo(anexos);
		daoLembrete.create(l);
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();	
		daoAnexo.closeEntityManager();
		daoLagitude.closeEntityManager();
		daoUsuario.closeEntityManager();
		return ("O tempo da operação CREATE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String retrieve() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		
		Lembrete lembrete = daoLembrete.retrieve(1l);
		//System.out.println(lembrete.getAnexo().size());
		
		//FECHANDO ENTITY MANAGER
		//em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação RETRIEVE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String update() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPAnexo daoAnexo = new DAOJPAnexo(em);
		
		for(int i=0; i<(quant*3)+1; i++) {
			Anexo anexo = new URL();
			anexo.setIdanexo(i+1);
			anexo.setDescricao("Nova descrição");
			anexo.setPosicaoNoLembrete(5);
			daoAnexo.update(anexo);			
		}
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoAnexo.closeEntityManager();		
		return ("O tempo da operação UPDATE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}
	
	private static String delete() {
		long tempoInicial = System.nanoTime();
		//CRIANDO ENTITY MANAGER, INICIANDO TRANSAÇÃO E INSTANCIANDO DAO DO USUARIO
		EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
				
		//DELETANDO LEMBRETE
		Lembrete l = new Lembrete();
		l.setIdLembrete(1);
		daoLembrete.delete(l);
		
		//EFETUANDO TRANSAÇÃO E FECHANDO ENTITY MANAGER
		em.getTransaction().commit();
		daoLembrete.closeEntityManager();		
		return ("O tempo da operação DELETE foi: "+ (System.nanoTime() - tempoInicial)+" nanosegundos");
	}

}
