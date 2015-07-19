package com.main.collection;


public class UserName implements Comparable<UserName >{

	private String lastName;
	private String firstName;
	private Integer age;
	private int userId;

	public UserName(String firstName, String lastName, int age) {
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public boolean equals(Object o){
		if(!(o instanceof UserName))
			return false;
		UserName name = (UserName) o;
		return name.getFirstName().equals(firstName) && name.getLastName().equals(lastName);
	}

	public int hashCode() {
		return 35*firstName.hashCode() + lastName.hashCode();
	}

	public String toString() {
		return firstName + " " + lastName+ " "+age;
	}

	public int compareTo(UserName u){
		int lastCmp = firstName.compareTo(u.getFirstName());
		return (lastCmp != 0 ? lastCmp : lastName.compareTo(u.getLastName()));
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



}
