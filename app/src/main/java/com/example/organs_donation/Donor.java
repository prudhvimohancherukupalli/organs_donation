package com.example.organs_donation;
public class Donor {
    private String name;
    private String age;
    private String bloodGroup;
    private String phone;
    private String health;

    public Donor() {
        // Default constructor required for calls to DataSnapshot.getValue(Donor.class)
    }

    public Donor(String name, String age, String bloodGroup, String phone, String health) {
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.health = health;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
