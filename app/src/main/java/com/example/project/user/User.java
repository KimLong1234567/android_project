package com.example.project.user;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String confpassword;
    private String contactno;

    public User(){

    }

    public User(String firstname, String lastname, String email, String confpassword, String contactno) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.confpassword = confpassword;
        this.contactno = contactno;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getConfpassword() {
        return confpassword;
    }

    public String getContactno() {
        return contactno;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
}
