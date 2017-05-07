package cart.action;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import product.daomain.Product;
import product.service.ProductService;
import cart.daomain.Cart;
import cart.daomain.CartItem;

/**
 * 购物车Action
 */
@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartAction {

	// 接收pid
	private Integer pid;
	// 接收数量count
	private Integer count;
	// 注入商品的Service
	@Resource(name="productServiceID")
	private ProductService productService;

	// 将购物项添加到购物车:执行的方法
	@RequestMapping("/addCart")
	public String addCart(Integer pid,Integer count,@ModelAttribute("cartSession") Cart cartSession,ModelMap model) {
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		// 设置数量:
		cartItem.setCount(count);
		// 根据pid进行查询商品:
		Product product = productService.findByPid(pid);
		// 设置商品:
		cartItem.setProduct(product);
		// 将购物项添加到购物车.
		// 购物车应该存在session中.
		Cart cart = getCart(cartSession, model);
		cart.addCart(cartItem);

		return "/WEB-INF/jsp/cart/cart";
	}

	// 清空购物车的执行的方法:
	@RequestMapping("/clearCart")
	public String clearCart(@ModelAttribute("cartSession") Cart cartSession,ModelMap model) {
		// 获得购物车对象.
		Cart cart = getCart(cartSession, model);
		// 调用购物车中清空方法.
		cart.clearCart();
		return "/WEB-INF/jsp/cart/cart";
	}

	// 从购物车中移除购物项的方法:
	@RequestMapping("/removeCart")
	public String removeCart(int pid,@ModelAttribute("cartSession") Cart cartSession,ModelMap model) {
		// 获得购物车对象
		Cart cart = getCart(cartSession, model);
		// 调用购物车中移除的方法:
		cart.removeCart(pid);
		// 返回页面:
		return "/WEB-INF/jsp/cart/cart";
	}

	// 我的购物车:执行的方法
	@RequestMapping("/myCart")
	public String myCart() {
		return "/WEB-INF/jsp/cart/cart";
	}

	/**
	 * 获得购物车的方法:从session中获得购物车.
	 */
	private Cart getCart(@ModelAttribute("cartSession") Cart cartSession,ModelMap model) {
        System.out.println(cartSession);
        if(null == cartSession){
        	Cart cart = new Cart();
        	model.addAttribute("cartSession", cart);
        	return cart;
        }
        return cartSession;
		/*Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;*/
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
