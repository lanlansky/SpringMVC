package com.imooc.object;

public class User {
	
	private String name;
	private int age;
	private ContactInfo contactInfo;
	
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{"+"name='"+name+'\''+",age="+age+",contactInfo="+contactInfo+'}';
	}
	
	

}
