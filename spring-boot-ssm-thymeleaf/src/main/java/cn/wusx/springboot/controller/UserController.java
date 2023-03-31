package cn.wusx.springboot.controller;

import cn.wusx.springboot.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wusx.springboot.model.UserEntity;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public ModelAndView showUserList(int pageNum, int pageSize) {
		PageInfo<UserEntity> pageInfo = userService.getUserList(pageNum, pageSize);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
}

