package com.ads.bd2.agenda.modelo;

import javax.persistence.Entity;

@Entity
public class URL extends Anexo {

	private String url;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public URL() {
		
	}
}
