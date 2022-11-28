package DTO;

public class member {

	String id;
	String name;
	int age;
	String phoneNum;
	String address;
	
	public member(String id, String name, int age, String phoneNum, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}