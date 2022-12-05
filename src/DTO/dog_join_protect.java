package DTO;

public class dog_join_protect {
	int num;
	String name;
	String kind;
	String gender;
	String protect_agency;
	String protect_name;
	String protect_address;
	

	public dog_join_protect(int num, String name, String kind, String gender,
			String protect_agency,	String protect_name,String protect_address) {
		this.num = num;
		this.name = name;
		this.kind = kind;
		this.gender = gender;
		this.protect_agency = protect_agency;
		this.protect_name = protect_name;
		this.protect_address = protect_address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProtect_agency() {
		return protect_agency;
	}

	public void setProtection_agency(String protect_agency) {
		this.protect_agency = protect_agency;
	}
	
	public String getProtect_name() {
		return protect_name;
	}

	public void setProtect_name(String protect_name) {
		this.protect_name = protect_name;
	}
	
	public String getAddress() {
		return protect_address;
	}

	public void setAddress(String protect_address) {
		this.protect_address = protect_address;
	}
	
	
}