package com.imooc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.object.Admin;
import com.imooc.object.User;
import com.imooc.object.UserListForm;
import com.imooc.object.UserMapForm;
import com.imooc.object.UserSetForm;

@Controller
public class TestController {
	
	
	@RequestMapping(value="baseType.do")
	@ResponseBody
	//@RequestParam("xage") 表示是一个别名，必须用这个别名进行传值
	public String baseType(@RequestParam("xage") int age){
		return "age:"+age;	
	}
	
	@RequestMapping(value="baseType2.do")
	@ResponseBody
	//Integer 包装类型可以为空
	public String baseType2(Integer age){
		return "age:"+age;	
	}
	@RequestMapping(value="array.do")
	@ResponseBody
	//http://localhost:8080/springmvc/array.do?name=tom&name=lucy&name=jim
	public String array(String[] name){
		StringBuilder sbf=new StringBuilder();
		for(String item:name){
			sbf.append(item).append(" ");
		}
		return sbf.toString();	
	}
	
	@RequestMapping(value="object.do")
	@ResponseBody
	//简单对象的绑定
	//http://localhost:8080/springmvc/object.do?name=tom&age=10
	//当需要绑定下级对象的数据时
	//http://localhost:8080/springmvc/object.do?name=tom&age=10&contactInfo.phone=10086
	public String object(User user){
		return user.toString();	
	}
	
	@RequestMapping(value="objects.do")
	@ResponseBody
	//请求：http://localhost:8080/springmvc/objects.do?name=tom&age=10
	//结果：User{name='tom',age=10,contactInfo=null} Admin{name='tom',age=10}
	
	public String objects(User user,Admin admin){
		return user.toString()+"  "+admin.toString();	
	}
	//这个注解只作用于当前的controller
	//请求：http://localhost:8080/springmvc/objects.do?user.name=tom&admin.name=lucy&age=10
	//结果：User{name='tom',age=10,contactInfo=null} Admin{name='lucy',age=10}
	@InitBinder("user")
	public void initUser(WebDataBinder binder){	
		binder.setFieldDefaultPrefix("user.");
	}
	@InitBinder("admin")
	public void initAdmin(WebDataBinder binder){	
		binder.setFieldDefaultPrefix("admin.");
	}
	
	@RequestMapping(value="list.do")
	@ResponseBody
	//List<User> userList直接将List作为参数是行不通的，应该再建一个类来做中转
	//请求：http://localhost:8080/springmvc/list.do?users[0].name=tom&users[1].name=lucy
	//结果：UserListForm{users=[User{name='tom',age=0,contactInfo=null}, User{name='lucy',age=0,contactInfo=null}]}
	
	
	//http://localhost:8080/springmvc/list.do?users[0].name=tom&users[1].name=lucy&users[20].name=jim
	/*结果size:21 UserListForm{users=[User{name='tom',age=0,contactInfo=null}, User{name='lucy',age=0,
	contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, 
	User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,
	contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null},
	User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,
	contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, 
	User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null},
	User{name='null',age=0,contactInfo=null}, User{name='null',age=0,contactInfo=null}, User{name='jim',age=0,contactInfo=null}]}
	 * */
	//所以传值的时候地址要连写，否则会浪费很多空间
	public String list(UserListForm userListForm){
		return "size:"+userListForm.getUsers().size()+"  "+userListForm.toString();	
	}
	
	@RequestMapping(value="set.do")
	@ResponseBody
	//http://localhost:8080/springmvc/set.do?users[0].name=tom&users[1].name=lucy
	//UserSetForm{users=[User{name='tom',age=0,contactInfo=null}, User{name='lucy',age=0,contactInfo=null}]}
	public String set(UserSetForm userSetForm){
		return userSetForm.toString();	
	}
	@RequestMapping(value="map.do")
	@ResponseBody
	//http://localhost:8080/springmvc/map.do?users['x'].name=tom&users['x'].age=10&users['y'].name=lucy
	//UserMapForm{users={x=User{name='tom',age=10,contactInfo=null}, y=User{name='lucy',age=0,contactInfo=null}}}
	public String map(UserMapForm userMapForm){
		return userMapForm.toString();	
	}
	
	
	@RequestMapping(value="json.do")
	@ResponseBody
	
	//http://localhost:8080/springmvc/json.do
	/*{
    "name":"jim",
    "age":16,
    "contactInfo":{
        "address":"beijing",
        "phone":"10010"
    	}
	}*/

	//User{name='jim',age=16,contactInfo=ContactInfo{phone='10010',address=beijing'}}
	public String json(@RequestBody User user){
		return user.toString();	
	}
	@RequestMapping(value="xml.do")
	@ResponseBody
	//http://localhost:8080/springmvc/xml.do
	/*
	 * 
	 <?xml version="1.0"  encoding="UTF-8"?>
	<admin>
    	<name>jim</name>
    	<age>16</age>
	</admin>
	 * */
	//Admin{name='jim',age=16}
	public String xml(@RequestBody Admin admin){
		return admin.toString();	
	}
}
