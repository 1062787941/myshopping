package category.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import category.dao.CategoryDao;
import category.daomain.Category;
import categorysecond.daomain.CategorySecond;

public class TestCategory {
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CategoryDao dao = (CategoryDao) context.getBean("categoryDao");
		List<Category> list = dao.findAll();
		for(Category c : list){
			Set<CategorySecond> cc = c.getCategorySeconds();
			for (CategorySecond str : cc) {
			      System.out.println(str.getCsname());
			}
//			System.out.println(c.getCategorySeconds()+"--");
		}
//		dao.save(new Category(11, "颜色"));
//		System.out.println(dao.findByCid(1));
//		dao.delete(new Category(11, "颜色"));
//		dao.update(new Category(11, "ceshi"));
	}

}
