package com.example.myapplication.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("address")
    String address;
    @SerializedName("date_of_birth")
    String date_of_birth;
    @SerializedName("scheduleDTOs")
    List<ScheduleDTO> scheduleDTOs;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDTO(int id, String name, String email, String address, String date_of_birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.date_of_birth = date_of_birth;

    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<ScheduleDTO> getScheduleDTOs() {
        return scheduleDTOs;
    }

    public void setScheduleDTOs(List<ScheduleDTO> scheduleDTOs) {
        this.scheduleDTOs = scheduleDTOs;
    }
}
