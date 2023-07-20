package org.carrental.UI;

import org.carrental.domain.User;
import org.carrental.service.AuhenticationService;

import javax.swing.*;
import java.awt.*;
import java.net.Authenticator;

public class LogInUI {

    private final AuhenticationService auhenticationService = new AuhenticationService();

    public LogInUI(){
        //Define Frame
        JFrame jf = new JFrame("RENTAL CAR APP");

        JTextField textField1 = new JTextField("UserName");
        textField1.setBounds(150,100,200,30);

        JTextField textField2 = new JTextField("Password");
        textField2.setBounds(150,150,200,30);

        JButton button = new JButton("LogIn");
        button.setBounds(150,200,160,50);



        jf.add(textField1);
        jf.add(textField2);
        jf.add(button);

        button.addActionListener((event)->{
            if(auhenticationService.checkLogin(textField1.getText(),textField2.getText())){
                jf.dispose();
                new HomeUi();
            }else {
                JOptionPane.showMessageDialog(jf,"Inccorect Password");
            }
                });

        jf.setSize(500,500);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        

    }

}
