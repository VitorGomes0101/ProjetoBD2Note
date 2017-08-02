package com.ads.bd2.agenda.modelo;

import javax.persistence.Entity;

@Entity
public class Imagem extends Anexo {

	private int caminhoSistemaArquivos;

	public int getCaminhoSistemaArquivos() {
		return caminhoSistemaArquivos;
	}

	public void setCaminhoSistemaArquivos(int caminhoSistemaArquivos) {
		this.caminhoSistemaArquivos = caminhoSistemaArquivos;
	}

	
}
