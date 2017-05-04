package category.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import category.daomain.Category;
import category.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryAction {
	private CategoryService categoryServiceId;
	@Resource(name="categoryServiceID")
	public void setCategoryServiceId(CategoryService categoryServiceId) {
		this.categoryServiceId = categoryServiceId;
	}
	
	@RequestMapping("/findAll")//查找所有的以及目录
	public String findAll(Model model){
		List<Category> listscategory = categoryServiceId.findAll();
		model.addAttribute("listscategory", listscategory);
		return "/category/findAll";
	}
	
	// 保存一级分类的方法
	@RequestMapping("/save")
	public String save(Category category){
		// 调用Service完成保存一级分类
		categoryServiceId.save(category);
		// 进行页面跳转:
		return "/category/saveSuccess";
	}
		
	// 删除一级分类的方法:
	@RequestMapping("/delete")
	public String delete(Category category){
		// 调用Service完成 一级分类的删除
		// 级联删除一定先查询在删除:
		categoryServiceId.delete(category);
		return "/category/deleteSuccess";
	}
		
	// 编辑一级分类的方法:
	@RequestMapping("/edit")
	public String edit(Category category){
		// 根据cid进行查询:
		category = categoryServiceId.findByCid(category.getCid());
		//将一级分类数据显示到页面上.
		return "/category/editSuccess";
	}
		
	// 修改一级分类的方法:
	@RequestMapping("update")
	public String update(Category category){
		// 使用模型驱动接收前台提交数据:
		categoryServiceId.update(category);
		return "/category/updateSuccess";
	}
}
