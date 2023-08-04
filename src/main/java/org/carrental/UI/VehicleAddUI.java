package org.carrental.UI;

import org.carrental.service.VehicleService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VehicleAddUI  {

    public static void main(String[] args) {
        new VehicleAddUI();
    }


    VehicleService vehicleService = new VehicleService();

    public VehicleAddUI(){

        JFrame jf = new JFrame("ADD Vehicle UI");

        jf.setLayout(new GridLayout(9,10,10,10));


        JLabel errorLabel  = new JLabel("");
        errorLabel.setForeground(Color.RED);

        JLabel jname = new JLabel("NAME");
        JTextField jTextField = new JTextField(20);


        JLabel jyear = new JLabel("Year");
        JTextField jy = new JTextField(20);

        JLabel jmodel = new JLabel("Model");
        JTextField jm = new JTextField(20);

        JLabel jbrand = new JLabel("Brand");
        JTextField jb = new JTextField(20);

        JLabel jcolor = new JLabel("Color");
        JTextField jc = new JTextField(20);

        JLabel joid = new JLabel("OID");
        String[] vehicleOptions = vehicleService.getAllOwners();
        JComboBox<String> dropwdownVehicle = new JComboBox<>(vehicleOptions);
//        JTextField jo = new JTextField(20);

//        JLabel jbook = new JLabel("BOoking Status");
//        JTextField jTextbook = new JTextField(20);

        JButton backButton = new JButton("BaCK");

        JButton insertButton = new JButton("SAVE");

        backButton.addActionListener(e->{
            jf.dispose();
            new CustomerPanelUI();
        });


        insertButton.addActionListener(e->{

                try {

                    String name = jTextField.getText();
                    String year = String.valueOf(Integer.valueOf(jy.getText()));
                    String model = String.valueOf(Integer.valueOf(jm.getText()));
                    String bRand = jb.getText();
                    String cOlor = jc.getText();
                    String oid    = (String) dropwdownVehicle.getSelectedItem();
                    String[] partsVehicle = oid.split(",");
                    Integer vehicleOwnerId = Integer.valueOf(partsVehicle[0]);
                   // String bookingStatus = jTextbook.getText();


                    int maxNameLength = 100;
                    int maxPhoneNumberLength = 20;
                    int maxCityLength = 100;
                    int maxAddressLength = 150;
                    int maxCommentsLength = 200;

                    if (name.length() > maxNameLength || year.length() > maxPhoneNumberLength ||
                            model.length() > maxCityLength || bRand.length() > maxAddressLength ||
                            cOlor.length() > maxCommentsLength || oid.length() >maxCommentsLength )  {
                        errorLabel.setText("Text exceed the maximum ALlowed Length");
                    }

                    vehicleService.add(name, Integer.valueOf(year), Integer.valueOf(model),
                            bRand,cOlor, String.valueOf(vehicleOwnerId));
                    jf.dispose();
                    new VehiclePaneUI();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jf, "Unable to Connect");
                }


        });



        jf.add(jname);
        jf.add(jTextField);

        jf.add(jyear);
        jf.add(jy);

        jf.add(jmodel);
        jf.add(jm);

        jf.add(jbrand);
        jf.add(jb);

        jf.add(jcolor);
        jf.add(jc);

            jf.add(joid);
            jf.add(dropwdownVehicle);
//        jf.add(jo);

//        jf.add(jbook);
//        jf.add(jTextbook);

        jf.add(backButton);
        jf.add(insertButton);

        jf.add(errorLabel);

        jf.setSize(500,500);
        // jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);



    }


}
