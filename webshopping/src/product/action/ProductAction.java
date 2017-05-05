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
	
	@RequestMapping("/findByCid")	//点击一级目录
	public String findByCid(int cid,int page,Model model){
		PageBean<Product> productByCid = productService.findByPageCid(cid, page);
		model.addAttribute("cid", cid);
		model.addAttribute("pageBeanByCid", productByCid);
		return "/WEB-INF/jsp/product/productList";
	}
	
	@RequestMapping("/findByCsid")	//点击二级目录
	public String findByCsid(int csid,int page,Model model){
		PageBean<Product> productByCsid = productService.findByPageCsid(csid, page);
		model.addAttribute("csid", csid);
		model.addAttribute("pageBeanByCid", productByCsid);
		return "/WEB-INF/jsp/product/productList";
	}
	
	@RequestMapping("/findByPid")//展示商品
	public String findByPid(int pid,Model model){
		Product product = productService.findByPid(pid);
		model.addAttribute("product", product);
		return "/WEB-INF/jsp/product/product";
	}
	
	
	
	
	
}
