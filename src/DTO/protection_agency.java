package DTO;

public class protection_agency {
	String num;
	String name;
	String address;
	String phone_number;
	int count;
	
	public protection_agency(String num, String name, String address, String phone_number, int count) {
		this.num = num;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.count = count;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
