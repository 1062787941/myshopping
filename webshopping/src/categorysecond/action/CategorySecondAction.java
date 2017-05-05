package categorysecond.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import categorysecond.service.CategorySecondService;

@Controller
@RequestMapping(value="/categorySecond")
public class CategorySecondAction {
	
	private CategorySecondService secondService;
	@Resource(name="categorySecondServiceID")
	public void setSecondService(CategorySecondService secondService) {
		this.secondService = secondService;
	}
	
	
}
