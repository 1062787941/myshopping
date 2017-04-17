package user.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.dao.UserDao;
import user.daomain.User;

public class TestUser {
	
	@Test
	public void test() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		User user = new User(99, "aaa", "aaa", "哈哈", "aaa@shop.com", "15726607618", "北京市西三旗中腾建华3楼", 1, null, null);
		UserDao dao= (UserDao) applicationContext.getBean("userDao");
		
//		dao.save(user);
//		User u = dao.findByCode("123456789");
//		System.out.println(u.getName());
		
//		dao.update(new User(1, "xxxxx", "xxx", "哈哈", "aaa@shop.com", "15726607618", "北京市西三旗中腾建华3楼", 1, null, null));
		User u1 = dao.login(user);
		System.out.println(u1.getPassword());
	}

}
