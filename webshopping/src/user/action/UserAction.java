package user.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	private UserService userServiceID;
	// 接收验证码:
	private String checkcode;
	
	@Resource(name="userServiceID")
	public void setUserServiceID(UserService userServiceID) {
		this.userServiceID = userServiceID;
	}
	
	/**
	 * 用户注册的方法:
	 */
	@RequestMapping("regist")
	public String regist() {
		// 判断验证码程序:
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码输入错误!");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}

}
