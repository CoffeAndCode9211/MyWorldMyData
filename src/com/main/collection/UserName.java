package com.main.collection;


public class UserName implements Comparable<UserName> {

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

    public UserName(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }


    public String toString() {
        return firstName + " " + age;
    }

    public int compareTo(UserName u) {
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
