/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel García
 */
public class ContactGUI extends javax.swing.JFrame {

    /**
     * Creates new form ContactGUI
     */
    ArrayList<Contact> contactList;
    
    public ContactGUI() {
        initComponents();
        
        contactList = new ArrayList<>();
        //Hide business field by default
        lblCompanyname.setVisible(false);
        txtCompanyname.setVisible(false);
        
        //Load list from file
        getListFromFile();
    }
    
    private void add(){
        String firstname = txtFirstname.getText();
        String surname = txtSurname.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        int phone = Integer.parseInt(txtPhone.getText());
        
        if(radContact.isSelected()){
            Contact tempC = new Contact(firstname, surname, email, address, phone);
            contactList.add(tempC);
            addToFile();
            txtareaDisplay.setText("Contact '" + tempC.getFirstname() + " " + tempC.getLastname() + "' added to list!");
            clear();
        }else if(radBusiness.isSelected()){
            String companyName = txtCompanyname.getText();
            
            BusinessContact tempB = new BusinessContact(companyName, firstname, surname, email, address, phone);
            contactList.add(tempB);
            addToFile();
            txtareaDisplay.setText("Contact '" + tempB.getFirstname() + " " + tempB.getLastname() + "' added to list!");
            clear();
        }
        
    }
    
    private void display(){
        String output = "";
        for(int i = 0; i<contactList.size(); i++){
            output += contactList.get(i).toString();
        }
        txtareaDisplay.setText(output);
    }
    
    private void delete(int phone){
        for(int i = 0; i<contactList.size(); i++){
            if(phone == contactList.get(i).getPhone()){
                //If phone is in the list, delete it
                txtareaDisplay.setText("Contact '" + contactList.get(i).getFirstname() + " " + contactList.get(i).getLastname() + "' deleted!");
                contactList.remove(i);
            }
        }
    }
    
    private void clear(){
        txtFirstname.setText("");
        txtSurname.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtCompanyname.setText("");
    }
    
    private void addToFile(){
        File f;
        FileOutputStream fo;
        ObjectOutputStream oo;
        
        try{
            f = new File("output.dat");
            fo = new FileOutputStream(f);
            oo = new ObjectOutputStream(fo);
            
            oo.writeObject(contactList);
            
            oo.close();
            fo.close();
            
        }catch(IOException e){
            System.out.println("Error when writing to file: " + e);
        }
    }
    
    private void getListFromFile(){
        File f;
        FileInputStream fi;
        ObjectInputStream oi;
        
        try{
            f = new File("output.dat");
            fi = new FileInputStream(f);
            oi = new ObjectInputStream(fi);
            
            contactList = (ArrayList<Contact>) oi.readObject();
            display();
            
        }catch(FileNotFoundException fnf){
            txtareaDisplay.setText("The Contact list is empty.");
            System.out.println("The file does not exist: " + fnf);
        }catch(ClassNotFoundException cnf){
            System.out.println("Object does not exist: " + cnf);
        }catch(IOException e){
            System.out.println("Error when reading file: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaDisplay = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        radContact = new javax.swing.JRadioButton();
        radBusiness = new javax.swing.JRadioButton();
        lblCompanyname = new javax.swing.JLabel();
        txtCompanyname = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setText("Contact GUI");

        lblFirstname.setText("First Name");

        lblSurname.setText("Last Name");

        lblEmail.setText("Email");

        lblPhone.setText("Phone number");

        lblAddress.setText("Address");

        txtareaDisplay.setColumns(20);
        txtareaDisplay.setRows(5);
        jScrollPane1.setViewportView(txtareaDisplay);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnGroup.add(radContact);
        radContact.setSelected(true);
        radContact.setText("Contact");
        radContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radContactActionPerformed(evt);
            }
        });

        btnGroup.add(radBusiness);
        radBusiness.setText("Business Contact");
        radBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBusinessActionPerformed(evt);
            }
        });

        lblCompanyname.setText("Company Name");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnExit)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPhone)
                        .addGap(332, 332, 332))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(111, 111, 111))))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(radContact, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radContact)
                    .addComponent(radBusiness))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompanyname)
                            .addComponent(txtCompanyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstname)
                            .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSurname)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        // TODO add your handling code here:
        display();
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int phoneDel = Integer.parseInt(JOptionPane.showInputDialog("Please introduce phone number for delete"));
        delete(phoneDel);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void radContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radContactActionPerformed
        // TODO add your handling code here:
        lblCompanyname.setVisible(false);
        txtCompanyname.setVisible(false);
    }//GEN-LAST:event_radContactActionPerformed

    private void radBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBusinessActionPerformed
        // TODO add your handling code here:
        lblCompanyname.setVisible(true);
        txtCompanyname.setVisible(true);
    }//GEN-LAST:event_radBusinessActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCompanyname;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton radBusiness;
    private javax.swing.JRadioButton radContact;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCompanyname;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextArea txtareaDisplay;
    // End of variables declaration//GEN-END:variables
}
