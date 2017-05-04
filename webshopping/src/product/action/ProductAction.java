package product.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import product.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductAction {

	private ProductService productService;
	@Resource(name="productServiceID")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/findByCid")
	public String findByCid(){
		return "";
	}
	
}
