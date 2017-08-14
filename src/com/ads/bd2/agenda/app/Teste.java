package com.ads.bd2.agenda.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.LatitudeLongitude;
import com.ads.bd2.agenda.modelo.Usuario;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALatitudeLongitude;
import com.ads.bd2.agenda.persistencia.DAOJPALembrete;
import com.ads.bd2.agenda.persistencia.DAOJPAUsuario;

public class Teste {

	public static void main(String[] args) {
		//faremos um compartilhamento do EntityManager entre os DAOs para otimizarmos as operacoes 
		//comuns numa sessao de trabalho (operacoes numa mesma transacao).
		//por isso abriremos e fecharemos a transacao do EntityManager (commit) fora dos DAOs
				
		/*EntityManager em = DAOJPA.createAndInitEntityManager(); //---> chamando o EntityManager		
		em.getTransaction().begin();//---> abrindo a transacao
		DAOJPA<LatitudeLongitude> daoLatLong = new DAOJPALatitudeLongitude(em); //---> criando um DAO para um objeto persistente especifico, com o mesmo EntityManager
		
		
		//se outros objetos fossem persistidos criariamos o respectivo DAO desse objeto passando o mesmo EntityManager
		
		
		//criando um objeto
		LatitudeLongitude latLong = new LatitudeLongitude();
		latLong.setLatitude(90);
		latLong.setLongitude(100);
		
		//persistindo
		daoLatLong.create(latLong);
		
		
		em.getTransaction().commit();//---> fechando a transacao
		daoLatLong.closeEntityManager();//---> fechando o EntityManager*/
		
		/*EntityManager em = DAOJPA.createAndInitEntityManager();
		em.getTransaction().begin();
		DAOJPALembrete daoLembrete= new DAOJPALembrete(em);
		DAOJPAUsuario daoUsuario= new DAOJPAUsuario(em);
		
		Usuario usuario = new Usuario();
		usuario.setLogin("jadson");
		usuario.setNome("Jadson");
		usuario.setSenha("123");
		usuario.setEmail("jadson@gmail.com");
		usuario.setDataNascimento(new Date(System.currentTimeMillis()));		
		daoUsuario.create(usuario);
		
		Usuario novo = new Usuario();
		novo.setLogin("jadson");
		novo.setNome("Vitor");
		novo.setSenha("1567");
		novo.setEmail("sad@gmail.com");
		novo.setDataNascimento(new Date(System.currentTimeMillis()));		
		daoUsuario.update(novo);
		
		daoUsuario.delete(novo);
        em.getTransaction().commit();
		 */


	}

}
