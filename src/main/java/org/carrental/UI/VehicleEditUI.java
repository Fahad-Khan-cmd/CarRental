package org.carrental.UI;

import org.carrental.service.VehicleService;

import javax.swing.*;
import java.awt.*;

public class VehicleEditUI {
        VehicleService vehicleService = new VehicleService();
    public VehicleEditUI(String id, String vName, String vBrand, String vYear, String vColor, String vModel, String oID) {

        JFrame jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(10,10,10,10));

        JLabel jname = new JLabel("VName");
        JTextField jTextField = new JTextField(20);
        jTextField.setText(vName);


        JLabel jbrand = new JLabel("VBrand");
        JTextField jTextb = new JTextField(20);
        jTextb.setText(vBrand);

        JLabel jyear = new JLabel("VYear");
        JTextField jTexty = new JTextField(20);
        jTexty.setText(vYear);

        JLabel jModel = new JLabel("VModel");
        JTextField jTextm = new JTextField(20);
        jTextm.setText(vModel);

        JLabel jColor = new JLabel("VColor");
        JTextField jTextc = new JTextField(20);
        jTextc.setText(vColor);

        JLabel joID = new JLabel("OID");
        String[] vehicleOptions = vehicleService.getAllOwners();
        JComboBox<String> dropwdownVehicle = new JComboBox<>(vehicleOptions);
        dropwdownVehicle.setSelectedItem(oID);

        //JTextField jTextid = new JTextField(20);
        //jTextid.setText(oID);

        JButton updateBtn = new JButton();

        updateBtn.addActionListener(e->{
            String oid    = (String) dropwdownVehicle.getSelectedItem();
            String[] partsVehicle = oid.split(",");
            Integer vehicleOwnerId = Integer.valueOf(partsVehicle[0]);
                vehicleService.updateVehicle(id,jTextField.getText(), Integer.valueOf(jTexty.getText()), jTextb.getText(),Integer.valueOf(jTextm.getText()),jTextc.getText(),vehicleOwnerId);

                jFrame.dispose();
                new VehiclePaneUI();
        });

        JButton back = new JButton("Back");
        back.addActionListener(e->{
            jFrame.dispose();
            new VehiclePaneUI();
        });


        jFrame.add(jname);
        jFrame.add(jTextField);

        jFrame.add(jyear);
        jFrame.add(jTexty);

        jFrame.add(jbrand);
        jFrame.add(jTextb);

        jFrame.add(jModel);
        jFrame.add(jTextm);

        jFrame.add(jColor);
        jFrame.add(jTextc);

        jFrame.add(joID);
        jFrame.add(dropwdownVehicle);
        //jFrame.add(jTextid);

        jFrame.add(updateBtn);
        jFrame.add(back);


        jFrame.setSize(500,500);
        // jf.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);


    }
}
