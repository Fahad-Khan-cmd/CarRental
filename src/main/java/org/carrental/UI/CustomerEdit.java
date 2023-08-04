package org.carrental.UI;

import org.carrental.service.CustomerService;

import javax.swing.*;
import java.awt.*;

public class CustomerEdit {

    CustomerService customerService = new CustomerService();



    public CustomerEdit(String id , String name, String phoneNumber, String cnic, String address, String refPhoneNumber){
        JFrame jf = new JFrame("Edit CUSTOMER UI");

        jf.setLayout(new GridLayout(10,10,10,10));


//        JLabel jid = new JLabel("ID");
//        JTextField jTextFieldCustomerId = new JTextField(20);
//        jTextFieldCustomerId.setText(id);

        JLabel jname = new JLabel("NAME");
        JTextField jTextField = new JTextField(20);
        jTextField.setText(name);

        JLabel jphone = new JLabel("PhoneNumber");
        JTextField jtextp = new JTextField(20);
        jtextp.setText(phoneNumber);

        JLabel jcnic = new JLabel("CNIC");
        JTextField jTextc = new JTextField(20);
        jTextc.setText(cnic);

        JLabel jaddress = new JLabel("address");
        JTextField jaddtext = new JTextField(20);
        jaddtext.setText(address);

        JLabel jref = new JLabel("Ref PhoneNumber");
        JTextField jTextref = new JTextField(20);
        jTextref.setText(refPhoneNumber);





        JButton backButton = new JButton("BaCK");

        JButton updatebutton = new JButton("Update");

        backButton.addActionListener(e->{
            jf.dispose();
            new CustomerPanelUI();
        });



        updatebutton.addActionListener(e -> {
            customerService.update(String.valueOf(Long.valueOf(id)), jTextField.getText(), jtextp.getText(), jTextc.getText(), jaddtext.getText(), jTextref.getText());
            jf.dispose();
            new CustomerPanelUI();
        });


//        jf.add(jid);
//        jf.add(jTextFieldCustomerId);

        jf.add(jname);
        jf.add(jTextField);

        jf.add(jphone);
        jf.add(jtextp);

        jf.add(jcnic);
        jf.add(jTextc);

        jf.add(jaddress);
        jf.add(jaddtext);

        jf.add(jref);
        jf.add(jTextref);


        jf.add(backButton);
        jf.add(updatebutton);


        jf.setSize(500,500);
        // jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


    }

}
