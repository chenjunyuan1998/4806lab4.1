package com.example.servingwebcontent.app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfos = new ArrayList<>();
    @Id
    @GeneratedValue
    private long id;


    public AddressBook() {

    }

    public void addBuddy(BuddyInfo aa) {
        if (aa != null) {
            buddyInfos.add(aa);
        }
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int size(){
        return buddyInfos.size();
    }

    public void clear(){
        this.buddyInfos = null;
    }

    public String toString() {

        String addresses = "";

        for (BuddyInfo buddy : this.buddyInfos) {

            addresses += buddy.toString() + "\n";

        }
        System.out.println(addresses);
        return addresses;

    }

    public void removeBuddy() {
        if ( buddyInfos.size()!=0) {
            buddyInfos.remove(0);
        }
    }

    public BuddyInfo getBuddy(int i) {
        if (i >= 0 && i < buddyInfos.size()) {
            return buddyInfos.get(i);
        }
        return null;
    }


    public List<BuddyInfo> getBuddyInfos(){
        return buddyInfos;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos){
        this.buddyInfos = buddyInfos;
    }

  /*  public static void main(String[] args){
        AddressBook a = new AddressBook();
        BuddyInfo aa = new BuddyInfo("aaa","111","231321321");
        BuddyInfo bb = new BuddyInfo("bbb","222","221321321");
        a.addBuddy(aa);
        a.addBuddy(bb);
        a.removeBuddy();
        a.toString();
    }*/

}
