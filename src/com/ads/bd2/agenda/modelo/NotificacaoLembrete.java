package com.ads.bd2.agenda.modelo;

import java.util.Date;

public class NotificacaoLembrete {

	private Date dataHoraLembrar;

	private ModoNotificacao modo;

	private boolean confirmado;

	private Usuario usuario;

	public Date getDataHoraLembrar() {
		return dataHoraLembrar;
	}

	public void setDataHoraLembrar(Date dataHoraLembrar) {
		this.dataHoraLembrar = dataHoraLembrar;
	}

	public ModoNotificacao getModo() {
		return modo;
	}

	public void setModo(ModoNotificacao modo) {
		this.modo = modo;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
