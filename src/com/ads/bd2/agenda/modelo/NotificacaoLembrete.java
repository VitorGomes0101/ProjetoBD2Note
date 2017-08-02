package com.ads.bd2.agenda.modelo;

import java.util.Date;
import javax.persistence.*;

@Entity
public class NotificacaoLembrete {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idNotificao;

	private Date dataHoraLembrar;

	private ModoNotificacao modo;

	private boolean confirmado;
	
	@JoinColumn(name = "login", referencedColumnName = "login")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@JoinColumn(name = "idlembrete", referencedColumnName = "idlembrete")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Lembrete lembrete;

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

	public long getIdNotificao() {
		return idNotificao;
	}

	public void setIdNotificao(long idNotificao) {
		this.idNotificao = idNotificao;
	}

	public Lembrete getLembrete() {
		return lembrete;
	}

	public void setLembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
	}
	
	
	

}
