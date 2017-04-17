package orders.test;

import java.util.Date;
import java.util.List;

import orders.dao.OrderDao;
import orders.daomain.Order;
import orders.daomain.OrderItem;

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
		Order order = new Order(7001,(double) 83,new Date(),101, "姜涛","15726607618 ",
				" 北京市西三旗中",user,null);
//		dao.save(order);
//		int i = dao.findCountByUid(7);
//		System.out.println(i);
//		
//		List<Order> ls = dao.findPageByUid(7, 0, 10);
//		System.out.println(ls);
//		for(Order o :ls){
//			System.out.println(o.getName()+"--");
//		}
//		
//		dao.update(order);
//		int i = dao.findCount();
//		System.out.println(i);
//		List<Order> ls = dao.findByPage(0, 7);
//		System.out.println(ls);
//		for(Order o :ls){
//			System.out.println(o.getName()+"--");
//		}
		List<OrderItem> l = dao.findOrderItem(2000);
		for(OrderItem o : l){
			System.out.println(o.getItemid()+"---");
		}
	}
}
