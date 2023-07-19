package com.codegroup.service;

import java.util.List;

import com.codegroup.model.Projeto;

public interface ProjetoService {
	public void salvar(Projeto projeto);
	public List<Projeto> obterTodos();
	public void excluir(Projeto projeto);
}
