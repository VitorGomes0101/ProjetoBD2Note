package com.ads.bd2.agenda.modelo;

import javax.persistence.Entity;

@Entity
public class Imagem extends Anexo {

	private String caminhoSistemaArquivos;

	public String getCaminhoSistemaArquivos() {
		return caminhoSistemaArquivos;
	}

	public void setCaminhoSistemaArquivos(String caminhoSistemaArquivos) {
		this.caminhoSistemaArquivos = caminhoSistemaArquivos;
	}
	
	public Imagem() {
		
	}

	
}
