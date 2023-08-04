package org.carrental.UI;

import org.carrental.domain.VehicleOwner;
import org.carrental.service.VehicleOwnerService;

import javax.swing.*;
import java.awt.*;

public class VehicleOwnerAddUI {

    public static void main(String[] args) {
        new VehicleOwnerAddUI();
    }

    VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();

    public VehicleOwnerAddUI() {
        JFrame jf = new JFrame("Add VehicleOwner UI");


        jf.setLayout(new GridLayout(10, 10, 15, 15));





        JLabel jname = new JLabel("NAME");
        JTextField jTextField = new JTextField(20);





        JLabel jcnic = new JLabel("CNIC");
        JTextField jtextc = new JTextField(20);

        JLabel jphone = new JLabel("PHONENUMBER");
        JTextField jTextp = new JTextField(20);

        JLabel jaddress = new JLabel("ADDRESS");
        JTextField jaddtext = new JTextField(20);

        JLabel jcomm = new JLabel("COMMISION");
        JTextField jtextcom = new JTextField(20);


        JButton backButton = new JButton("BaCK");

        JButton addButton = new JButton("SAVE");

        backButton.addActionListener(e -> {
            jf.dispose();
            new CustomerPanelUI();
        });
        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        addButton.addActionListener(e -> {
            try {

                String name = jTextField.getText();
                String phone = jTextp.getText();
                String cnic = jtextc.getText();
                String address = String.valueOf(jaddtext.getText());
                String commision = jtextcom.getText();

                int maxNameLength = 100;
                int maxPhoneNumberLength = 20;
                int maxCityLength = 100;
                int maxAddressLength = 150;
                int maxCommentsLength = 200;

                if (name.length() > maxNameLength || phone.length() > maxPhoneNumberLength ||
                        cnic.length() > maxCityLength || address.length() > maxAddressLength ||
                        commision.length() > maxCommentsLength) {
                    errorLabel.setText("Text exceed the maximum ALlowed Length");
                }

                vehicleOwnerService.add(name, phone, cnic,
                        address, Float.valueOf(commision));
                jf.dispose();
                new VehicleOwnerPanelUI();


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jf, "Unable to Connect");
            }
        });






        jf.add(jname);
        jf.add(jTextField);

        jf.add(jphone);
        jf.add(jTextp);

        jf.add(jcnic);
        jf.add(jtextc);

        jf.add(jaddress);
        jf.add(jaddtext);

        jf.add(jcomm);
        jf.add(jtextcom);

        jf.add(backButton);
        jf.add(addButton);



        jf.add(errorLabel);
        jf.setSize(500, 500);
        // jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


    }
}