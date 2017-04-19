package product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return sessionFactory.openSession().
				selectList("ProductNameSpace.findHot");
	}

	@Override //首页上最新商品的查询
	public List<Product> findNew() {
		return sessionFactory.openSession().
				selectList("ProductNameSpace.findNew");
	}

	@Override // 根据商品ID查询商品
	public Product findByPid(Integer pid) {
		return sessionFactory.openSession().
					selectOne("ProductNameSpace.findByPid",pid);
	}

	/**
	 * ---------------TODO
	 */
	@Override// 根据分类id查询商品的个数
	public int findCountCid(Integer cid) {
		return sessionFactory.openSession().
				selectOne("ProductNameSpace.findCountCid",cid);
	}

	@Override// 根据分类id查询商品的集合
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("begin", begin);
		map.put("limit", limit);
		return sessionFactory.openSession().
				selectList("ProductNameSpace.findByPageCid",map);
	}

	@Override // 根据二级分类查询商品个数
	public int findCountCsid(Integer csid) {
		return sessionFactory.openSession().
				selectOne("ProductNameSpace.findCountCsid",csid);
	}

	@Override // 根据二级分类查询商品信息
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("csid", csid);
		map.put("begin", begin);
		map.put("limit", limit);
		return sessionFactory.openSession().
				selectList("ProductNameSpace.findByPageCsid",map);
	}

	@Override // 后台统计商品个数的方法
	public int findCount() {
		return sessionFactory.openSession().
				selectOne("ProductNameSpace.findCount");
	}

	@Override// 后台查询所有商品的方法
	public List<Product> findByPage(int begin, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("limit", limit);
		return sessionFactory.openSession().
				selectList("ProductNameSpace.findByPage",map);
	}

	@Override // DAO中的保存商品的方法
	public void save(Product product) {
		sessionFactory.openSession().insert("ProductNameSpace.save",product);
	}

	@Override// DAO中的删除商品的方法 
	public void delete(Product product) {
		sessionFactory.openSession().delete("ProductNameSpace.delete", product);
	}

	@Override //更新商品
	public void update(Product product) {
		sessionFactory.openSession().update("ProductNameSpace.update",product);
	}

}
