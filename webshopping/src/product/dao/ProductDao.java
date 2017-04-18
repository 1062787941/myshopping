package product.dao;

import java.util.List;

import product.daomain.Product;

public interface ProductDao {
	// 首页上热门商品查询
		public List<Product> findHot();
		
		// 首页上最新商品的查询
		public List<Product> findNew();
		
		// 根据商品ID查询商品
		public Product findByPid(Integer pid);
		
		// 根据分类id查询商品的个数
		public int findCountCid(Integer cid);
		
		// 根据分类id查询商品的集合
		public List<Product> findByPageCid(Integer cid, int begin, int limit) ;
		
		// 根据二级分类查询商品个数
		public int findCountCsid(Integer csid) ;
		
		// 根据二级分类查询商品信息
		public List<Product> findByPageCsid(Integer csid, int begin, int limit) ;
		
		// 后台统计商品个数的方法
		public int findCount() ;
		
		// 后台查询所有商品的方法
		public List<Product> findByPage(int begin, int limit);
		
		// DAO中的保存商品的方法
		public void save(Product product) ;
		
		// DAO中的删除商品的方法
		public void delete(Product product);
		
		// DAO中的更新商品的方法
		public void update(Product product);
}
