package DTO;

public class abandoned_dog {
	int num;
	String name;
	String kind;
	String gender;
	String age;
	String weight;
	String rescure_date;
	String discovery_place;
	String protect_num;
	String protection_agency;
	
	public abandoned_dog(int num, String name, String kind, String gender, String age, String weight, String rescure_date,
			String discovery_place, String protect_num, String protection_agency) {
		this.num = num;
		this.name = name;
		this.kind = kind;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.rescure_date = rescure_date;
		this.discovery_place = discovery_place;
		this.protect_num = protect_num;
		this.protection_agency = protection_agency;
	}
	public abandoned_dog(int num, String name, String kind) {
		this.num = num;
		this.name = name;
		this.kind = kind;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getRescure_date() {
		return rescure_date;
	}

	public void setRescure_date(String rescure_date) {
		this.rescure_date = rescure_date;
	}

	public String getDiscovery_place() {
		return discovery_place;
	}

	public void setDiscovery_place(String discovery_place) {
		this.discovery_place = discovery_place;
	}

	public String getProtect_num() {
		return protect_num;
	}

	public void setProtect_num(String protect_num) {
		this.protect_num = protect_num;
	}

	public String getProtection_agency() {
		return protection_agency;
	}

	public void setProtection_agency(String protection_agency) {
		this.protection_agency = protection_agency;
	}
	
	
}