package org.carrental.UI;

import org.carrental.domain.VehicleOwner;
import org.carrental.service.VehicleOwnerService;

import javax.swing.*;
import java.awt.*;

public class VehicleOwnerEditUI {



    VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();
        public VehicleOwnerEditUI(String id, String name, String phoneNumber, String cnic, String address, String commission){
            JFrame jf = new JFrame("Edit VehicleOwner UI");

            jf.setLayout(new GridLayout(7,10,10,10));


//            JLabel jid = new JLabel("JID");
//            JTextField jtextid = new JTextField(20);

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

            JLabel jcomm = new JLabel("Commision");
            JTextField jtextcom = new JTextField(20);
            jtextcom.setText(commission);

            JButton backButton = new JButton("BaCK");

            JButton editButton = new JButton("Update");

            backButton.addActionListener(e->{
                jf.dispose();
                new CustomerPanelUI();
            });



            editButton.addActionListener(e -> {
               // String Id = jtextid.getText();
                String updatedName = jTextField.getText();
                String updatedPhoneNumber = jtextp.getText();
                String updatedCnic = jTextc.getText();
                String updatedAddress = String.valueOf(jaddtext.getText());
                String updatedCommision = jtextcom.getText();

                vehicleOwnerService.editVehicleOwner(Integer.valueOf(id),jTextField.getText()
                , jtextp.getText(), jTextc.getText(), jaddtext.getText(), Float.valueOf(jtextcom.getText()));

                jf.dispose();
                new VehicleOwnerPanelUI();
            });


//            jf.add(jid);
//            jf.add(jtextid);

            jf.add(jname);
            jf.add(jTextField);

            jf.add(jphone);
            jf.add(jtextp);

            jf.add(jcnic);
            jf.add(jTextc);

            jf.add(jaddress);
            jf.add(jaddtext);

            jf.add(jcomm);
            jf.add(jtextcom);

            jf.add(backButton);
            jf.add(editButton);


            jf.setSize(500,500);
            // jf.setLayout(null);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
        }


}
