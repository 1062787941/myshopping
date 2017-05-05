package categorysecond.daomain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import product.daomain.Product;
import category.daomain.Category;

/**
 * 二级分类的实体
 */
public class CategorySecond implements Serializable{
	private Integer csid;
	private String csname;
	// 所属一级分类.存的是一级分类的对象.
	private Category category;
	// 配置商品集合
	private Set<Product> products = new HashSet<Product>();
	
	public CategorySecond(){}
	
	public CategorySecond(Integer csid, String csname, Category category,
			Set<Product> products) {
		this.csid = csid;
		this.csname = csname;
		this.category = category;
		this.products = products;
	}
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
