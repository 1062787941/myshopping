package product.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import product.daomain.Product;
import product.service.ProductService;
import util.PageBean;


@Controller
@RequestMapping("/product")
public class ProductAction {

	private ProductService productService;
	
	@Resource(name="productServiceID")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/findByCid")
	public String findByCid(int cid,int page,Model model){
		PageBean<Product> productByCid = productService.findByPageCid(cid, page);
		model.addAttribute("pageBeanByCid", productByCid);
		
		model.addAttribute("cid", cid);
		model.addAttribute("one", 1);
		return "/WEB-INF/jsp/product/productList";
	}
	
	
	@RequestMapping("/findByPid")
	public String findByPid(int pid,Model model){
		Product product = productService.findByPid(pid);
		model.addAttribute("product", product);
		return "/WEB-INF/jsp/product/product";
	}
	
}
