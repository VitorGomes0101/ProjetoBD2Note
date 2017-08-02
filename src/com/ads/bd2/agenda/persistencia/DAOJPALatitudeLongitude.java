package com.ads.bd2.agenda.persistencia;

import javax.persistence.EntityManager;

import com.ads.bd2.agenda.modelo.LatitudeLongitude;

public class DAOJPALatitudeLongitude extends DAOJPA<LatitudeLongitude> {

	public DAOJPALatitudeLongitude(EntityManager em) {
		super(em);
	}

	@Override
	public Class<LatitudeLongitude> getDAOClass() {
		return LatitudeLongitude.class;
	}
	
	//CRIAR OUTRAS CONSULTAS COM JPQL CAPAZES DE RETORNAR COMO RESULTADO UMA OU MAIS INSTANCIAS DESTE OBJETO, 
	//SE APLICAVEL NO QUE O PROJETO PEDE. EX.: public List<LatitudeLongitude> getLatitudeEntre(double x, double y, double x2, double y2)

}
