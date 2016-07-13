package com.imooc.object;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserSetForm {
	
	private Set<User> users;
	
	private UserSetForm(){
		//set�����ʼ��������Խ�磬new������user����ֻ�ܴ�����ֵ
		users= new LinkedHashSet<User>();
		users.add(new User());
		users.add(new User());
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserSetForm{"+"users="+users+'}';
	}

}
