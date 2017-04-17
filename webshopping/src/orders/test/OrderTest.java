package orders.test;

import java.util.Date;
import java.util.List;

import orders.dao.OrderDao;
import orders.daomain.Order;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.daomain.User;

public class OrderTest {

	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		OrderDao dao = (OrderDao) context.getBean("orderDao");
		User user = new User(7, "aaa", "aaa", "哈哈", "aaa@shop.com",
				"15726607618", "北京市西三旗中腾建华3楼", 1, null, null);
		Order order = new Order(7001,(double) 83,new Date(),1, "姜涛","15726607618 ",
				" 北京市西三旗中",user);
//		dao.save(order);
//		int i = dao.findCountByUid(1);
//		System.out.println(i);
		
//		List<Order> ls = dao.findPageByUid(8, 0, 2);
//		System.out.println(ls);
//		for(Order o :ls){
//			System.out.println(o.getName()+"--");
//		}
//		
//		dao.update(order);
		int i = dao.findCount();
		System.out.println(i);
		List<Order> ls = dao.findByPage(0, 7);
		
		System.out.println(ls);
		for(Order o :ls){
			System.out.println(o.getName()+"--");
		}
	}
}