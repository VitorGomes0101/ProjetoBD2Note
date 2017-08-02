package com.ads.bd2.agenda.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Lembrete {

	@Id
	private long idlembrete;

	private Date dataCriacao;

	private int titulo;

	private int texto;

	private int posicaoEntreLembretes;

	private Collection<Anexo> anexo;

	private Collection<Usuario> usuario;

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

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}

	public int getTexto() {
		return texto;
	}

	public void setTexto(int texto) {
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

	
	
	
}
