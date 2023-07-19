package service;

import java.util.Date;

import org.junit.Test;

import com.codegroup.model.Projeto;
import com.codegroup.service.impl.ProjetoServiceImpl;

public class TesteProjetoService {

	@Test
	public void testeProjetoServiceSave() {
		ProjetoServiceImpl projetoService = new ProjetoServiceImpl();
		
		Projeto projeto = new Projeto();
		projeto.setDataInicio(new Date());
		projeto.setNome("TEste");
		projeto.setOrcamento(23.5);
		
		projetoService.salvar(projeto);
	}
}
