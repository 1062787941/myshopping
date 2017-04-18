package product.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import product.dao.ProductDao;
import product.daomain.Product;

public class TestProduct {
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ProductDao dao = (ProductDao) context.getBean("productDao");
		List<Product> ls = dao.findHot();
		for(Product p : ls){
			System.out.println(p.getPdesc()+"---"+p.getPid());
		}
	}

}
