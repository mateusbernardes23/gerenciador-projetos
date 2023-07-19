package com.codegroup.managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.codegroup.model.Pessoa;
import com.codegroup.model.Projeto;
import com.codegroup.model.enums.Risco;
import com.codegroup.model.enums.Status;
import com.codegroup.service.PessoaService;
import com.codegroup.service.ProjetoService;
import com.codegroup.service.impl.PessoaServiceImpl;
import com.codegroup.service.impl.ProjetoServiceImpl;

@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean {
	private Projeto projeto = new Projeto();
	private List<Status> status;
	private List<Risco> risco;
	private List<Projeto> projetos = new ArrayList<>();
	private List<Pessoa> pessoas = new ArrayList<>();
	private ProjetoService projetoService = new ProjetoServiceImpl();
	private PessoaService pessoaService = new PessoaServiceImpl();

	public void iniciarBeanLista() {
		projetos = projetoService.obterTodos();
	}
	
	public void iniciarBeanFormulario() {
		status = Arrays.asList(Status.values());
		risco = Arrays.asList(Risco.values());
		pessoas = pessoaService.obterTodos();
	}

	public void salvar() {
		try {
			projetoService.salvar(projeto);
			FacesContext.getCurrentInstance().getExternalContext().redirect("");
			iniciarBeanLista();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editar(RowEditEvent<Projeto> event) {
		projetoService.salvar(event.getObject());
		mensagemPopup("Projeto Editado");
    }
     
    public void cancelarEdicao(RowEditEvent<Projeto> event) {
    	mensagemPopup("Edição Cancelada");
    }
    
    public void excluir(Projeto projeto) {
    	projetoService.excluir(projeto);
    	iniciarBeanLista();
    }
    
    public void mensagemPopup(String mensagem) {
    	FacesMessage msg = new FacesMessage(mensagem);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<Risco> getRisco() {
		return risco;
	}

	public void setRisco(List<Risco> risco) {
		this.risco = risco;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
