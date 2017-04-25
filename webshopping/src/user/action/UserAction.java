package user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import user.daomain.User;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	private UserService userService;
	
	@Resource(name="userServiceID")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 * 用户注册的方法:
	 * @throws Exception 
	 */
	@RequestMapping("/regist")
	public String regist(User user,Model model) throws Exception {
		userService.save(user);
		model.addAttribute("message","注册成功!请去邮箱激活!");
		return "/WEB-INF/jsp/msg";
	}
	
	/*
	 * 根据名字去查找
	 */
	

	@RequestMapping(value="user_findByName", method=RequestMethod.POST)  
	public  @ResponseBody User queryByName(String username,HttpServletRequest request) throws Exception{
        User u = userService.findByUsername(username);
        return u;
	}
}
