package com.imooc.object;



public class ContactInfo {

	public String phone;
	public String address;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ContactInfo{"+"phone='"+phone+'\''+",address="+address+'\''+'}';
	}
	
	
	
	
}
