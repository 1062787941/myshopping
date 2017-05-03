package user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import user.daomain.User;
import user.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("session_user")
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
	
	/*
	 * 用户登录
	 */
	@RequestMapping("login")
	public String login(User user,ModelMap model){
		System.out.println(user.getName()+user.getUsername()+"--"+user.getPassword());
		User existUser =userService.login(user);
		System.out.println(existUser);
		// 判断
		if (existUser == null) {
			System.out.println("----------------------");
			// 登录失败
			model.addAttribute("message","登录失败:用户名或密码错误或用户未激活!");
			return "/user/login";
		} else {
			// 登录成功
			// 将用户的信息存入到session中
			model.addAttribute("session_user", existUser);
		System.out.println("XXXXXXXXXXXXXXX");
			// 页面跳转
			return "/WEB-INF/jsp/index";
		}
	}
}
