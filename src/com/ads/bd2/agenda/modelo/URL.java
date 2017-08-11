package com.ads.bd2.agenda.modelo;

import javax.persistence.Entity;

@Entity
public class URL extends Anexo {

	private int url;
	
	public int getUrl() {
		return url;
	}
	
	public void setUrl(int url) {
		this.url = url;
	}
	
	public URL() {
		
	}
}
