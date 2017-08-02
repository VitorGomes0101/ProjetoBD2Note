package com.ads.bd2.agenda.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuario", schema="public")
public class Usuario {
	
	@Column(name = "nome", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private int nome;

	@Column(name = "datanascimento", nullable = false, insertable = true, updatable = true, unique = false)
	private Date dataNascimento;

	@Id
	@Column(name = "login", nullable = false, length = 255, insertable = true, updatable = true, unique = true)
	private int login;

	@Column(name = "senha", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private int senha;

	@Column(name = "email", nullable = false, length = 255, insertable = true, updatable = true, unique = true)
	private int email;

	@JoinTable(name = "lembrete_usuario", joinColumns = {@JoinColumn(name = "login_usuario", referencedColumnName = "login")}, inverseJoinColumns = {@JoinColumn(name = "idlembrete", referencedColumnName = "idlembrete")})
	@ManyToMany
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
