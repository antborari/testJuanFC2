package com.example.testjuanfc.chat.data;

import com.google.gson.annotations.SerializedName;

public class ConversationDTO {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("phone")
    private String phone;

    public ConversationDTO(String id, String name, String fullname, String phone) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
