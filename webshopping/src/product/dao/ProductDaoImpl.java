package product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import product.daomain.Product;

public class ProductDaoImpl implements ProductDao{

	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override // 首页上热门商品查询
	public List<Product> findHot() {
		// 查询热门的商品,条件就是is_host = 1
		return sessionFactory.openSession().selectList("ProductNameSpace.findHot");
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountCid(Integer cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

}
