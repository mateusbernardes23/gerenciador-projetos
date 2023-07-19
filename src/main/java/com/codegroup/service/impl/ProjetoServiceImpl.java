package com.codegroup.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.codegroup.config.HibernateUtil;
import com.codegroup.model.Projeto;
import com.codegroup.service.ProjetoService;

public class ProjetoServiceImpl implements ProjetoService{

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(Projeto projeto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(projeto);
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> obterTodos() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Projeto> projetos = entityManager.createQuery("from Projeto").getResultList();
		transaction.commit();
		
		return projetos;
	}

	@Override
	public void excluir(Projeto projeto) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(projeto);
		transaction.commit();	
	}
}
