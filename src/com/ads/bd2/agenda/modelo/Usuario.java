package com.ads.bd2.agenda.modelo;

import java.util.Collection;
import java.util.Date;

public class Usuario {

	private int nome;

	private Date dataNascimento;

	private int login;

	private int senha;

	private int email;

	private Collection<Lembrete> lembrete;

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public Collection<Lembrete> getLembrete() {
		return lembrete;
	}

	public void setLembrete(Collection<Lembrete> lembrete) {
		this.lembrete = lembrete;
	}
	
}
