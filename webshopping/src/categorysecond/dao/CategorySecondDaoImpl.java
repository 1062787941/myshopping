package categorysecond.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import categorysecond.daomain.CategorySecond;

public class CategorySecondDaoImpl implements CategorySecondDao{

	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override //统计二级分类个数的方法
	public int findCount() {
		return sessionFactory.openSession().selectOne("CategorySecondNameSpace.findCount");
	}

	@Override // DAO中分页查询的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("limit", limit);
		return sessionFactory.openSession().
				selectList("CategorySecondNameSpace.findByPage", map);
	}
	
	@Override // DAO中的保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		sessionFactory.openSession().
			insert("CategorySecondNameSpace.save",categorySecond);
	}

	@Override // DAO中的删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		sessionFactory.openSession().delete("CategorySecondNameSpace.delete", categorySecond);
	}

	@Override //根据id查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		return sessionFactory.openSession().selectOne("CategorySecondNameSpace.findByCsid", csid);
	}

	@Override //修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		sessionFactory.openSession().update("CategorySecondNameSpace.update", categorySecond);
	}

	@Override //查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		return sessionFactory.openSession().selectList("CategorySecondNameSpace.findAll");
	}

}
