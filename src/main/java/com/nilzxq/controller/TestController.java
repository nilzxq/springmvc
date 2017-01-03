package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zxq @date 2017年1月3日
 *
 */
@Controller
public class TestController {

	@RequestMapping(value="baseType.do")
	@ResponseBody
	public String baseType(int age){
		return "age:"+age;
		
	}
}
