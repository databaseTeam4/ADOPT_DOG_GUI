package DTO;

import java.sql.Date;

public class missing {

	String animal_num;
	String dog_name;
	String dog_kind;
	String sex;
	String unique;
	String miss_place;
	String miss_time;
	Date miss_date;
	String id;
	
	public missing(String animal_num, String dog_name, String dog_kind, String sex, String unique, String miss_place,
			String miss_time, Date miss_date, String id) {
		
		this.animal_num = animal_num;
		this.dog_name = dog_name;
		this.dog_kind = dog_kind;
		this.sex = sex;
		this.unique = unique;
		this.miss_place = miss_place;
		this.miss_time = miss_time;
		this.miss_date = miss_date;
		this.id = id;
	}
	
	public missing(String animal_num, String dog_name, String dog_kind,Date miss_date, String id) {
		
		this.animal_num = animal_num;
		this.dog_name = dog_name;
		this.dog_kind = dog_kind;
		this.miss_date = miss_date;
		this.id = id;
	}

	public String getAnimal_num() {
		return animal_num;
	}

	public void setAnimal_num(String animal_num) {
		this.animal_num = animal_num;
	}

	public String getDog_name() {
		return dog_name;
	}

	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}

	public String getDog_kind() {
		return dog_kind;
	}

	public void setDog_kind(String dog_kind) {
		this.dog_kind = dog_kind;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public String getMiss_place() {
		return miss_place;
	}

	public void setMiss_place(String miss_place) {
		this.miss_place = miss_place;
	}

	public String getMiss_time() {
		return miss_time;
	}

	public void setMiss_time(String miss_time) {
		this.miss_time = miss_time;
	}

	public Date getMiss_date() {
		return miss_date;
	}

	public void setMiss_date(Date miss_date) {
		this.miss_date = miss_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}