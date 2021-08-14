package com.example.animelist.pojos;

public class UserInformation {
    private static UserInformation myInstance = null;
    private String email;
    private String username;
    private String password;
    private String birthday;
    private String phoneNumber;
    private String gender;

    private UserInformation() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public static synchronized UserInformation getInstance() {
        if(myInstance == null) {
            myInstance = new UserInformation();
        }
        return myInstance;
    }
}
