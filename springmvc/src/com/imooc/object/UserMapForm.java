package com.imooc.object;

import java.util.Map;

public class UserMapForm {
	
	private Map<String,User> users;

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserMapForm{"+"users="+users+"}";
	}
	

}
