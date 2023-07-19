package config;

import org.junit.Test;

import com.codegroup.config.HibernateUtil;

public class TesteHibernate {
	
	@Test
	public void testeHibernate() {
		HibernateUtil.getEntityManager();
	}
}
