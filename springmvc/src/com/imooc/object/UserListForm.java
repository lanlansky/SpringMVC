package com.imooc.object;

import java.util.List;

public class UserListForm {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserListForm{"+"users="+users+'}';
	}

}
