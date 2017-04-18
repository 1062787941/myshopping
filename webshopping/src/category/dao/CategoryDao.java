package category.dao;

import java.util.List;

import category.daomain.Category;


public interface CategoryDao {
	//DAO层的查询所有一级分类的方法
	public List<Category> findAll();
	
	// Dao中的保存一级分类的方法
	public void save(Category category);
	
	// Dao中根据一级分类id查询一级分类
	public Category findByCid(Integer cid);
	
	// DAO中删除一级分类
	public void delete(Category category);
	
	// Dao中修改一级分类
	public void update(Category category);
}
