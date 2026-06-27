package com.sgabello.sgabeachmanager.modules;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String notes;


    public Client(int id, String firstName, String lastName, String phone, String notes){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.notes = notes;
    }

    public int getId(){return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPhone() {return phone;}
    public String getNotes() {return notes;}

    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setNotes(String notes) {this.notes = notes;}


}
