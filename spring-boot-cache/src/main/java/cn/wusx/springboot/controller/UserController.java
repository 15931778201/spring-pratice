package cn.wusx.springboot.controller;

import java.util.List;

import cn.wusx.springboot.common.aop.ControllerWebLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.wusx.springboot.model.UserEntity;
import cn.wusx.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 *  查找所有
	 * @return
	 */
	@RequestMapping("/getAll")
	public List<UserEntity> getAll(){
		return userService.getAll(); 
	}
	/**
	 * 根据id获取用户
	 * @return
	 */
	@RequestMapping("/getOne")
	public UserEntity getOne(Long id){
		return userService.getOne(id); 
	}
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(UserEntity user) {
		userService.insertUser(user);
		return "insert success";
	}	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(UserEntity user) {
		userService.updateUser(user);
		return "update success";
	}

	@GetMapping("/getOne")
	@ControllerWebLog(name = "查询", intoDb = true)
	public String getOne(Long id, String name) {

		return "1234";
	}
}
