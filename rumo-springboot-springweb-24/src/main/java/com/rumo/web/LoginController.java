package com.rumo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rumo.pojo.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpSession session) {
		User user = (User) session.getAttribute("session_user");
		if (user != null) {
			// 重定向到首页去
			return "redirect:/admin/index";
		}
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		// 重定向到后台页面
		return "redirect:/login";
		// return "redirect:login";
	}

	/*@GetMapping("/logined")
	public String logined(HttpSession session) {

		User user = new User();
		user.setId(100);
		user.setUsername("mofeng");
		user.setBirthday(new Date());
		user.setAge(32);

		session.setAttribute("session_user", user);
		// 重定向到后台页面
		return "redirect:/admin/index";
		// return "redirect:admin/index";
	}*/
	
	@GetMapping("/logined")
	public String logined(RedirectAttributes redirectAttributes,HttpSession session) {

		User user = new User();
		user.setId(100);
		user.setUsername("mofeng");
		user.setBirthday(new Date());
		user.setAge(32);
		//这种方式就相当于重定向之后，在url后面拼接参数，这样在重定向之后的页面或者控制器再去获取url后面的参数就可以了，但这个方式因为是在url后面添加参数的方式，所以暴露了参数，有风险
		redirectAttributes.addAttribute("sname", user.getUsername());
		//第二种： attr.addFlashAttribute("param", value);
		//这种方式也能达到重新向带参，而且能隐藏参数，其原理就是放到session中，session在跳到页面后马上移除对象。所以你刷新一下后这个值就会丢掉
		redirectAttributes.addFlashAttribute("params1", user.getUsername());
		redirectAttributes.addFlashAttribute("params2", user.getAge());
		session.setAttribute("session_user", user);
		// 重定向到后台页面
		return "redirect:/admin/index";
		// return "redirect:admin/index";
	}

	/**
	 * http://localhost:8080/saveuser?id=1&username=mofeng&age=32&birthday=1986-02-07
	 * 12:12:12
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveuser")
	@ResponseBody
	public User saveUser(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("/getstr")
	@ResponseBody
	public String getstr() {
		return "你好墨风";
	}

	@RequestMapping("/saveuser2")
	@ResponseBody
	public User saveuser2(HttpServletRequest request) throws ParseException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		String birthday = request.getParameter("birthday");

		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setAge(Integer.parseInt(age));
		user.setUsername(username);
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		return user;
	}
}
