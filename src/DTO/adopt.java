package DTO;

import java.sql.Date;

public class adopt{

	String adopt_num;
	Date adopt_date;
	String adopt_dog_name;
	String adopt_dog_kind;
	String adopt_dog_sex;
	String shelter_num;
	String id;
	
	public adopt(String adopt_num, Date adopt_date, String adopt_dog_name, String adopt_dog_kind, String adopt_dog_sex,
			String shelter_num, String id) {
		
		this.adopt_num = adopt_num;
		this.adopt_date = adopt_date;
		this.adopt_dog_name = adopt_dog_name;
		this.adopt_dog_kind = adopt_dog_kind;
		this.adopt_dog_sex = adopt_dog_sex;
		this.shelter_num = shelter_num;
		this.id = id;
	}

	public String getAdopt_num() {
		return adopt_num;
	}

	public void setAdopt_num(String adopt_num) {
		this.adopt_num = adopt_num;
	}

	public Date getAdopt_date() {
		return adopt_date;
	}

	public void setAdopt_date(Date adopt_date) {
		this.adopt_date = adopt_date;
	}

	public String getAdopt_dog_name() {
		return adopt_dog_name;
	}

	public void setAdopt_dog_name(String adopt_dog_name) {
		this.adopt_dog_name = adopt_dog_name;
	}

	public String getAdopt_dog_kind() {
		return adopt_dog_kind;
	}

	public void setAdopt_dog_kind(String adopt_dog_kind) {
		this.adopt_dog_kind = adopt_dog_kind;
	}

	public String getAdopt_dog_sex() {
		return adopt_dog_sex;
	}

	public void setAdopt_dog_sex(String adopt_dog_sex) {
		this.adopt_dog_sex = adopt_dog_sex;
	}

	public String getShelter_num() {
		return shelter_num;
	}

	public void setShelter_num(String shelter_num) {
		this.shelter_num = shelter_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}