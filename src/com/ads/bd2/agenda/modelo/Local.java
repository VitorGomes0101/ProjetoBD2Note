package com.ads.bd2.agenda.modelo;

public class Local extends Anexo {

	private String cep;

	private String cidade;

	private String estado;

	private String pais;

	private LatitudeLongitude latitudeLongitude;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LatitudeLongitude getLatitudeLongitude() {
		return latitudeLongitude;
	}

	public void setLatitudeLongitude(LatitudeLongitude latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}
	
	

}
