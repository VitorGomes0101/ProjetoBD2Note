package com.ads.bd2.agenda.app;

import javax.persistence.EntityManager;
import com.ads.bd2.agenda.modelo.LatitudeLongitude;
import com.ads.bd2.agenda.persistencia.DAOJPA;
import com.ads.bd2.agenda.persistencia.DAOJPALatitudeLongitude;

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
		

	}

}
