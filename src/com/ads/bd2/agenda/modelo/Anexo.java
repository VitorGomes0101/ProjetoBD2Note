package com.ads.bd2.agenda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "anexo", schema="public")
public class Anexo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idanexo;
	
	private int descricao;

	private int posicaoNoLembrete;
	
	@JoinColumn(name = "idlembrete", referencedColumnName = "idlembrete")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lembrete lembrete;

	public int getDescricao() {
		return descricao;
	}

	public void setDescricao(int descricao) {
		this.descricao = descricao;
	}

	public int getPosicaoNoLembrete() {
		return posicaoNoLembrete;
	}

	public void setPosicaoNoLembrete(int posicaoNoLembrete) {
		this.posicaoNoLembrete = posicaoNoLembrete;
	}

	public long getIdanexo() {
		return idanexo;
	}

	public void setIdanexo(long idanexo) {
		this.idanexo = idanexo;
	}

	public Lembrete getLembrete() {
		return lembrete;
	}

	public void setLembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
	}
	
	

}
