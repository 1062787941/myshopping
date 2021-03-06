package index.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import product.daomain.Product;
import product.service.ProductService;
import user.daomain.User;
import cart.daomain.Cart;
import category.daomain.Category;
import category.service.CategoryService;
/**
 * 首页访问的Action
 */
@Controller
@SessionAttributes({"categoryList","hotList","newList","cartSession","session_user"})
public class IndexAction{
	// 注入一级分类的Service:
	private CategoryService categoryService;
	// 注入商品的Service
	private ProductService productService;
	@Resource(name="categoryServiceID")
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Resource(name="productServiceID")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * 执行的访问首页的方法:
	 */
	@RequestMapping("/index")
	public String execute(Model model){
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存入到Session的范围:
		model.addAttribute("categoryList", cList);
		// 查询热门商品:
		List<Product> hList = productService.findHot();
		// 保存到值栈中:
		model.addAttribute("hotList", hList);
		// 查询最新商品:
		List<Product> nList = productService.findNew();
		// 保存到值栈中:
		model.addAttribute("newList", nList);
		Cart cartSession = new Cart();
		
		User user = new User();
		model.addAttribute("session_user", user);
		
		
		model.addAttribute("cartSession", cartSession);
		return "/WEB-INF/jsp/index";
	}
	
}
