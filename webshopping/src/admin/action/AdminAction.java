package admin.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import admin.daomain.Admin;
import admin.service.AdminService;

@Controller
@RequestMapping(value="/admin")
@SessionAttributes("exitAdmin")
public class AdminAction {
	
	private AdminService adminService;
	@Resource(name="adminServiceID")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	// 后台登录的执行的方法
	@RequestMapping(value="/adminLogin.action")
	public String adminLogin(Admin admin,Model model) throws Exception{
		System.out.println("------------------------");
		Admin exitAdmin = adminService.login(admin);
		model.addAttribute("exitAdmin", exitAdmin);
		//判断
		if(null == exitAdmin){//登录失败
			//用户名或密码错误
			String msg = "用户名或密码错误!";
			model.addAttribute("msg", msg);
			return "/admin/index";
		}else{//登录成功
			
			return "/admin/home";
		}
	}
	
}
