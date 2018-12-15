package com.bowen.top.stzb.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bowen.top.stzb.Repository.UserRepository;
import com.bowen.top.stzb.dao.UserMapper;
import com.bowen.top.stzb.doman.User;
import com.bowen.top.stzb.doman.UserExample;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/user", tags="测试接口模块")
@RestController
@RequestMapping(value = "/user")
public class TestController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	private final UserRepository userRepository;
	
	@Autowired
	public TestController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/user")
	@ApiOperation("添加一个新的用户。")
	public User save(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		return userRepository.save(user);
	}
	
	@PostMapping("/userDB")
	@ApiOperation("添加一个新的用户。数据库")
	public int saveDB(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		return userMapper.insertSelective(user);
	}
	
	@GetMapping("/usersDB")
	@ApiOperation("获取所有用户。数据库")
	public Collection<User> save() {
		UserExample example = new UserExample();
		return userMapper.selectByExample(example );
	}
	@GetMapping("/i18nZH")
	@ApiOperation("测试中文")
	public String i18n() {
		return messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale());
	}
}
