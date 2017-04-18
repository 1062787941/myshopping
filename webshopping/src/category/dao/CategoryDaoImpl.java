package category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import category.daomain.Category;

public class CategoryDaoImpl implements CategoryDao{

	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override //查询所有一级分类的方法
	public List<Category> findAll() {
		return sessionFactory.openSession().selectList("CategoryNameSpace.findAll");
	}

	@Override //保存一级分类的方法
	public void save(Category category) {
		sessionFactory.openSession().insert("CategoryNameSpace.save",category);
	}

	@Override  //根据一级分类id查询一级分类
	public Category findByCid(Integer cid) {
		return sessionFactory.openSession().selectOne("CategoryNameSpace.findByCid", cid);
	}

	@Override //删除一级分类
	public void delete(Category category) {
		sessionFactory.openSession().delete("CategoryNameSpace.delete", category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

}
