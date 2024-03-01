/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class NhanVien {
    private String NV_id;
    private String first_name;
    private String last_name;
    private String address;
    private LocalDate birth_date;
    private String gender;
    private String email;
    private String user_name;
    private String pass_word;
    private String role;
    private String phone;

    public NhanVien(String NV_id, String first_name, String last_name, String address, LocalDate birth_date, String gender, String email, String user_name, String pass_word, String role, String phone) {
        this.NV_id = NV_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.birth_date = birth_date;
        this.gender = gender;
        this.email = email;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.role = role;
        this.phone = phone;
    }
    
    public NhanVien() {
    }

    public String getNV_id() {
        return NV_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public void setNV_id(String NV_id) {
        this.NV_id = NV_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "NV_id=" + NV_id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", birth_date=" + birth_date + ", gender=" + gender + ", email=" + email + ", user_name=" + user_name + ", pass_word=" + pass_word + ", role=" + role + ", phone=" + phone + '}';
    }
}
