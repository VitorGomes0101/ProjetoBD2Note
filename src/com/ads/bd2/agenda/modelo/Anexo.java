package com.ads.bd2.agenda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "anexo", schema="public")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_ANEXO")
public abstract class Anexo {
	//@TableGenerator(name = "VEHICLE_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idanexo;
	
	@Column(name = "descricao", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private String descricao;

	@Column(name = "posicao_lembrete", nullable = false, insertable = true, updatable = true, unique = false)
	private int posicaoNoLembrete;
	
	@JoinColumn(name = "idlembrete", referencedColumnName = "idlembrete")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Lembrete lembrete;

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
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
	
	public Anexo() {
		
	}
	

}
