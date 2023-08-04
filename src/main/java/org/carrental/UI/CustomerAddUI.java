package org.carrental.UI;

import org.carrental.service.CustomerService;
import sun.java2d.loops.CustomComponent;

import javax.swing.*;
import java.awt.*;

public class CustomerAddUI {

    CustomerService customerService = new CustomerService();

    public CustomerAddUI(){
        JFrame jf = new JFrame("ADD CUTOMER UI");

        jf.setLayout(new GridLayout(8,10,10,10));

        JLabel jname = new JLabel("NAME");
        JTextField jTextField = new JTextField(20);


        JLabel jphone = new JLabel("PhoneNumber");
        JTextField jtextp = new JTextField(20);

        JLabel jcnic = new JLabel("CNIC");
        JTextField jTextc = new JTextField(20);

        JLabel jaddress = new JLabel("address");
        JTextField jaddtext = new JTextField(20);

        JLabel jref = new JLabel("Ref PhoneNumber");
        JTextField jTextref = new JTextField(20);



        JButton backButton = new JButton("BaCK");

        JButton savebutton = new JButton("SAVE");

        backButton.addActionListener(e->{
            jf.dispose();
            new CustomerPanelUI();
        });

        savebutton.addActionListener(e->{


            try {
                customerService.save(jTextField.getText(),jtextp.getText(),jTextc.getText(),jaddtext.getText(),jTextref.getText());
                jf.dispose();
                new CustomerPanelUI();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(jf, "Unable to Connect");
            }

        });

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

//        jf.add(jbook);
//        jf.add(jTextbook);

        jf.add(backButton);
        jf.add(savebutton);


        jf.setSize(500,500);
       // jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


    }
}
