package com.codegroup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codegroup.model.enums.Risco;
import com.codegroup.model.enums.Status;


@Entity
@Table(name = "projeto")
//@NamedQueries({
//	@NamedQuery(name = Projeto.LISTAR_TODOS_PROJETOS, query = Projeto.LISTAR_TODOS_PROJETOS)
//})
public class Projeto {
	private Integer id;
	private String nome;
	private Date dataInicio;
	private Date dataPrevisaoFim;
	private Date dataFim;
	private String descricao;
	private Status status;
	private Double orcamento;
	private Risco risco;
	private Pessoa pessoa;
	
//	public static final String LISTAR_TODOS_PROJETOS = "select Projeto from Projeto";
	

	public Projeto() {
		super();
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "data_inicio")
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "data_previsao_fim")
	public Date getDataPrevisaoFim() {
		return dataPrevisaoFim;
	}

	public void setDataPrevisaoFim(Date dataPrevisaoFim) {
		this.dataPrevisaoFim = dataPrevisaoFim;
	}

	@Column(name = "data_fim")
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}
	
	@Enumerated(EnumType.STRING)
	public Risco getRisco() {
		return risco;
	}


	public void setRisco(Risco risco) {
		this.risco = risco;
	}


	@ManyToOne
	@JoinTable(name = "membros", joinColumns = {@JoinColumn(name = "idprojeto")}, inverseJoinColumns = {@JoinColumn(name = "idpessoa")})
	@JoinColumn(name = "idgerente")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
