package com.ads.bd2.agenda.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "lembrete", schema="public")
public class Lembrete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idlembrete;
	
	@Column(name = "data_cricao", nullable = false, insertable = true, updatable = true, unique = false)
	private Date dataCriacao;
	
	@Column(name = "titulo", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private String titulo;

	@Column(name = "texto", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private String texto;
	
	@Column(name = "posicao_lembrete", nullable = false, insertable = true, updatable = true, unique = false)
	private int posicaoEntreLembretes;
	
	@OneToMany(mappedBy = "lembrete")
	private Collection<Anexo> anexo;
	
	@JoinTable(name = "lembrete_usuario", joinColumns = {@JoinColumn(name = "id_lembrete", referencedColumnName = "idlembrete")}, inverseJoinColumns = {@JoinColumn(name = "login_usuario", referencedColumnName = "login")})
	@ManyToMany 
	private Collection<Usuario> usuario;
	
	@OneToMany(mappedBy = "lembrete")
	private Collection<NotificacaoLembrete> notificacaoLembrete;

	
	public long getIdLembrete() {
		return idlembrete;
	}
	
	public void setIdLembrete(long idlembrete) {
		this.idlembrete = idlembrete;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getPosicaoEntreLembretes() {
		return posicaoEntreLembretes;
	}

	public void setPosicaoEntreLembretes(int posicaoEntreLembretes) {
		this.posicaoEntreLembretes = posicaoEntreLembretes;
	}

	public Collection<Anexo> getAnexo() {
		return anexo;
	}

	public void setAnexo(Collection<Anexo> anexo) {
		this.anexo = anexo;
	}

	public Collection<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Collection<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Collection<NotificacaoLembrete> getNotificacaoLembrete() {
		return notificacaoLembrete;
	}

	public void setNotificacaoLembrete(Collection<NotificacaoLembrete> notificacaoLembrete) {
		this.notificacaoLembrete = notificacaoLembrete;
	}

	public Lembrete (){
		
	}
	
	
}
