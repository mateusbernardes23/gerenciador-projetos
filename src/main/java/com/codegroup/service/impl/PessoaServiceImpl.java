package com.codegroup.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.codegroup.config.HibernateUtil;
import com.codegroup.model.Pessoa;
import com.codegroup.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {
	private EntityManager entityManager = HibernateUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> obterTodos() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Pessoa> pessoas = entityManager.createQuery("from Pessoa").getResultList();
		transaction.commit();
		return pessoas;
	}
}
