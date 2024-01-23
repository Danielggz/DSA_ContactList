/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contact;

/**
 *
 * @author Daniel García
 * 22 ene 2024
 */
public class BusinessContact extends Contact{
    private String companyName;

    public BusinessContact(String companyName, String firstname, String lastname, String email, String address, int phone) {
        super(firstname, lastname, email, address, phone);
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBusiness Contact details: " + "\n Company Name: " + this.companyName; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
}
