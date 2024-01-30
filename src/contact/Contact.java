/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contact;

import java.io.Serializable;

/**
 *
 * @author Daniel García
 * 22 jan 2024
 */
public class Contact implements Serializable{
    private String firstname, lastname, email, address;
    private int phone;

    public Contact() {
    }

    public Contact(String firstname, String lastname, String email, String address, int phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phone = phone;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "\nContact: \n" + "Firstname: " + firstname + " | Lastname: " + lastname + " | Email: " + email + " | Address: " + address + " | Phone: " + phone;
    }
    
    
}
