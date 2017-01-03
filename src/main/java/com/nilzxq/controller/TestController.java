package com.nilzxq.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nilzxq.object.Admin;
import com.nilzxq.object.User;
import com.nilzxq.object.UserListForm;
import com.nilzxq.object.UserMapForm;
import com.nilzxq.object.UserSetForm;

/**
 *@author zxq @date 2017年1月3日
 *@controller 注解使类生效
 *@RequestMapping（value="",method = RequestMethod.GET） 指定请求和方法
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
	//数组
	@RequestMapping(value="array.do")
	@ResponseBody
	public String array(String[] name){
		StringBuffer sbf=new StringBuffer();
		for(String item:name){
			sbf.append(item).append(" ");
		}
		return sbf.toString();	
	}

	//TODO http://localhost:8080/springmvc/object.do?name=tome&age=10
	//当前对象的下级属性 类.属性
	//TODO http://localhost:8080/springmvc/object.do?name=tome&age=10&contactInfo.phone=10086
	//TODO http://localhost:8080/springmvc/object.do?user.name=tome&admin.name=array&age=10
	
	@RequestMapping(value="object.do")
	@ResponseBody
	public String object(User user,Admin admin){
		return user.toString()+" "+admin.toString();	
	}
	//在url中传递参数的出现同属性时，可以通过InitBinder方法进行初始化，在属性前加前缀来区别，
	//若没加前缀则是共有的
	
	@InitBinder("user")
	public void intUser(WebDataBinder binder){
	binder.setFieldDefaultPrefix("user.");
	}
	@InitBinder("admin")
	public void intAdmin(WebDataBinder binder){
	binder.setFieldDefaultPrefix("admin.");
	}
	
	//绑定list是通过索引的方式，索引要连续，不连续会造成前后台数据大小不一致浪费后台的存储空间。
	//http://localhost:8080/springmvc/list.do?users[0].name=Tome&users[1].name=Lily&users[20].name=Jane
	@RequestMapping(value="list.do")
	@ResponseBody
	public String List(UserListForm userListForm){
		return "listSize:"+userListForm.getUsers().size()+" "+userListForm.toString();	
	}
	
	//使用Set的时候需要先进行初始化
	//要使用Set的排重功能必须在对象中覆写hashcode和equals方法。
	//SpringMVC对Set支持并不太好，初始化进行排重时会导致size变小，致使无法接受更多的数据而抛出异常，所以我们开发一般优先使用List。
	//List和Set绑定需要一个信息收集对象
	//1、Set进行数据绑定时必须进行初始化，而List则不用
	//2、Set一般用于重复判断或排除重复
	//3、Set进行数据绑定与List非常相似，但必须初始化，并指定size空间。否则会抛出异常，形如List的序号跨界如果超出了size范围也是不允许的。
	//4、要使用Set的排重功能必须在对象中覆写hashcode和equals方法。
	//SpringMVC对Set支持并不太好，初始化进行排重时会导致size变小，致使无法接受更多的数据而抛出异常，所以我们开发一般优先使用List。
	@RequestMapping(value="set.do")
	@ResponseBody
	public String set(UserSetForm userSetForm){
		return userSetForm.toString();	
	}
	
	//TODO http://localhost:8080/springmvc/map.do?users[%27X%27].name=Tom&users[%27X%27].age=10&users[%27Y%27].name=Lucy
	@RequestMapping(value="map.do")
	@ResponseBody
	public String map(UserMapForm userMapForm){
		return userMapForm.toString();	
	}
	
	@RequestMapping(value="json.do")
	@ResponseBody
	public String json(@RequestBody User user){
		return user.toString();	
	}
}
