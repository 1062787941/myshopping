package product.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import categorysecond.daomain.CategorySecond;
import product.dao.ProductDao;
import product.daomain.Product;

public class TestProduct {
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ProductDao dao = (ProductDao) context.getBean("productDao");
//		List<Product> ls = dao.findHot();
//		List<Product> ls = dao.findNew();
//		Product p = dao.findByPid(1);
//		System.out.println(p.getPname());
//		List<Product> ls = dao.findByPageCid(5, 0, 10);
//		List<Product> ls = dao.findByPageCsid(1, 0, 5);
//		List<Product> ls = dao.findByPage(0, 5);
//		for(Product p : ls){
//			System.out.println(p.getPname()+"---"+p.getPid());
//		}
//		System.out.println(dao.findCountCid(1));
//		System.out.println(dao.findCount());
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(42);
		Product product = new Product(110, "ceshi", 110.5, 10.5, "xx/yy", 
				"怎么弄", 1, new Date(), categorySecond);
		
//		dao.update(product);
		dao.delete(product);
	}

}
