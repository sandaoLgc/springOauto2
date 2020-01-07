package com.jln.common.shrioAndJWT.controller;

import java.util.concurrent.Callable;

import com.jln.common.systemModule.enity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AsyncRequestController {

	@GetMapping("/async")
	public Callable<User> doAsync(){
		return ()->{
			Thread.sleep(5000);
			return (User)SecurityUtils.getSubject().getPrincipal();
		};
	}
}
