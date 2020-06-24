package com.example.testjuanfc.chat.data.randomuser;

public class UserDTO {

    private String gender;
    private String email;
    private String phone;

    public UserDTO(String gender, String email, String phone) {
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
