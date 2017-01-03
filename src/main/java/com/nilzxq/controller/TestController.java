package com.nilzxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@author zxq @date 2017年1月3日
 *@controller 注解使类生效
 *@RequestMapping（value="",meithod = RequestMethod.GET） 指定请求和方法
 *@RequestParam（value="",required = true）value参数别名 required 是否必传默认为true
 */
@Controller
public class TestController {

	//TODO http://localhost:8080/springmvc/baseType.do?xage=10
	@RequestMapping(value="baseType.do")
	@ResponseBody
	public String baseType(@RequestParam("xage") int age){
		return "age:"+age;	
	}
	//TODO http://localhost:8080/springmvc/baseType2.do
	//TODO http://localhost:8080/springmvc/baseType2.do?age=10
	@RequestMapping(value="baseType2.do")
	@ResponseBody
	public String baseType2(Integer age){
		return "age:"+age;	
	}
}
