package com.ads.bd2.agenda.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuario", schema="public")
public class Usuario {
	
	@Column(name = "nome", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private String nome;

	@Column(name = "datanascimento", nullable = false, insertable = true, updatable = true, unique = false)
	private Date dataNascimento;

	@Id
	@Column(name = "login", nullable = false, length = 255, insertable = true, updatable = true, unique = true)
	private String login;

	@Column(name = "senha", nullable = false, length = 255, insertable = true, updatable = true, unique = false)
	private String senha;

	@Column(name = "email", nullable = false, length = 255, insertable = true, updatable = true, unique = true)
	private String email;

	@JoinTable(name = "lembrete_usuario", joinColumns = {@JoinColumn(name = "login_usuario", referencedColumnName = "login")}, inverseJoinColumns = {@JoinColumn(name = "id_lembrete", referencedColumnName = "idlembrete")})
	@ManyToMany
	private Collection<Lembrete> lembrete;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Lembrete> getLembrete() {
		return lembrete;
	}

	public void setLembrete(Collection<Lembrete> lembrete) {
		this.lembrete = lembrete;
	}
	
}
