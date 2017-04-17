package admin.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import admin.dao.AdminDao;
import admin.daomain.Admin;

public class TestAdmin {

	@Test
	public void test(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		AdminDao dao = (AdminDao) applicationContext.getBean("adminDao");
		Admin admin = dao.login(new Admin (1,"admin","admin"));
		System.out.println(admin.getUid());
	}
}
