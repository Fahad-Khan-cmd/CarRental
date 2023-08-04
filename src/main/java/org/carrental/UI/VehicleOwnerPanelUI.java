package org.carrental.UI;

import org.carrental.domain.VehicleOwner;
import org.carrental.service.VehicleOwnerService;
import org.carrental.service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VehicleOwnerPanelUI {

    public static void main(String[] args) {
        new VehicleOwnerPanelUI();
    }

    VehicleOwnerService vehicleOwnerService = new VehicleOwnerService();

    public VehicleOwnerPanelUI(){
        JFrame frame = new JFrame("VEHICLE PANEL VIEW");

        JPanel jPanel = new JPanel();

        frame.setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        JTextField textField = new JTextField(30);

        String data[][] = vehicleOwnerService.getAllVehicleOwner();


        String column[] = {"ID", "NAME" ,   "CNIC" , "Phone_Number", "ADDRESS" , "COMMISION"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt = new JTable(dtm);
        jt.setBounds(33,40,250,250);
        JScrollPane sp = new JScrollPane(jt);

        jPanel.add(textField);
        jPanel.add(sp);

        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addVehicleBtn = new JButton("AddVehicleOwner");
        JButton editVehicleBtn = new JButton("EditVehicleOwner");
        JButton deleteVehicleBtn = new JButton("DeleteVehicleOwner");
        JButton back = new JButton("BACK");
        addVehicleBtn.addActionListener(e->{
            try {
                frame.dispose();
                new VehicleOwnerAddUI();


            }catch (Exception ex){
                JOptionPane.showMessageDialog(frame,"Unable to Connect");
            }
        });

        editVehicleBtn.addActionListener(e->{
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {
                String id = (String) jt.getValueAt(selectedRow, 0);
                String name = (String) jt.getValueAt(selectedRow, 1);
                String phoneNumber = (String) jt.getValueAt(selectedRow, 2);
                String cnic = (String) jt.getValueAt(selectedRow, 3);
                String address = (String) jt.getValueAt(selectedRow, 4);
                String commission = (String) jt.getValueAt(selectedRow, 5);

                frame.dispose();
                new VehicleOwnerEditUI(id, name,phoneNumber,cnic,address,commission);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to edit.");
            }
        });
        back.addActionListener(e->{
            frame.dispose();
            new HomeUi();
        });

        deleteVehicleBtn.addActionListener(e->{
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {

                String id = (String) jt.getValueAt(selectedRow, 0);
                vehicleOwnerService.deleteVehicleOwner(id);
                frame.dispose();
                new VehicleOwnerPanelUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to Delete.");
            }
        });


        actionButtonPanel.add(addVehicleBtn);
        actionButtonPanel.add(editVehicleBtn);
        actionButtonPanel.add(deleteVehicleBtn);
        actionButtonPanel.add(back);


        frame.setLayout(new GridLayout(1,0,150,5));

        frame.add(jPanel);
        frame.add(actionButtonPanel);

        frame.setSize(1500,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }

}
