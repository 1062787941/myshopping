package categorysecond.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import category.daomain.Category;
import categorysecond.dao.CategorySecondDao;
import categorysecond.daomain.CategorySecond;

public class TestSecond {
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CategorySecondDao dao = (CategorySecondDao) context.getBean("categorySecondDao");
//		System.out.println(dao.findCount());
//		List<CategorySecond> ls = dao.findByPage(0, 2);
//		for (CategorySecond c: ls) {
//			System.out.println(c.getCsname());
//		}
		Category category = new Category(11, "ceshi");
//		dao.save(new CategorySecond(42, "哈哈", category, null));
		
//		dao.delete(new CategorySecond(42, "哈哈", category, null));
//		System.out.println(dao.findByCsid(1).getCsname());
		
//		dao.update(new CategorySecond(42, "嘻嘻", category, null));
//		
//		List<CategorySecond> l = dao.findAll();
//		for(CategorySecond c:l){
//			System.out.println(c.getCsid()+"--"+c.getCsname());
//		}
//		
	}

}
