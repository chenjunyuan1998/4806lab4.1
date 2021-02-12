package com.example.servingwebcontent.app;


import javax.persistence.*;
@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    private String phone;

    public BuddyInfo(){

    }


    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public BuddyInfo(String name, String address, String phone) {

        this.name=name;
        this.address=address;
        this.phone=phone;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString(){
        String s = name +" "+ address +" "+ phone;
        return s;
    }
}