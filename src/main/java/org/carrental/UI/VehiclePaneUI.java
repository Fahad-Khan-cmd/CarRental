package org.carrental.UI;

import org.carrental.domain.Vehicle;
import org.carrental.service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VehiclePaneUI {
    public static void main(String[] args) {
        VehiclePaneUI obj = new VehiclePaneUI();
    }


    VehicleService vehicleService = new VehicleService();
    public VehiclePaneUI(){

        JFrame frame = new JFrame("Vehicle Panel");

        JPanel jPanel = new JPanel();

        frame.setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        JTextField textField = new JTextField(30);

        String data[][] = vehicleService.getAllVehicle();


        String column[] = {"ID", "VNAME" , "VBRAND" , "VYEAR" , "VCOLOR" , "VMODEL","ONAME"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt = new JTable(dtm);
        jt.setBounds(33,40,250,250);
        JScrollPane sp = new JScrollPane(jt);

        jPanel.add(textField);
        jPanel.add(sp);



        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addVehicleButton = new JButton("ADDVehicle");
        JButton editVehicleButton = new JButton("EditVehicle");
        JButton deleteVehicle = new JButton("DeleteVehicle");
        JButton back = new JButton("BACK");

        back.addActionListener(e->{
            frame.dispose();
            new HomeUi();
        });



        actionButtonPanel.add(addVehicleButton);
        actionButtonPanel.add(editVehicleButton);
        actionButtonPanel.add(deleteVehicle);
        actionButtonPanel.add(back);

        addVehicleButton.addActionListener(e->{
            frame.dispose();
            new VehicleAddUI();
        });

        editVehicleButton.addActionListener(e->{
            if(jt.getSelectedRow() >= 0 ){
                String id = (String) jt.getValueAt(jt.getSelectedRow(),0);
                String vName = (String) jt.getValueAt(jt.getSelectedRow(),1);
                String vBrand = (String) jt.getValueAt(jt.getSelectedRow(),2);
                String vYear = (String) jt.getValueAt(jt.getSelectedRow(),3);
                String vModel = (String) jt.getValueAt(jt.getSelectedRow(),4);
                String vColor = (String) jt.getValueAt(jt.getSelectedRow(),5);
                String oID    = (String) jt.getValueAt(jt.getSelectedRow(),6);

                frame.dispose();
                new VehicleEditUI(id, vName , vBrand , vYear , vModel , vColor , oID);
            }else {
                JOptionPane.showMessageDialog(frame,"Unable to Connect");
            }

        });

        deleteVehicle.addActionListener(e->{
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {

                String id = (String) jt.getValueAt(selectedRow, 0);
                vehicleService.deleteVehicle(Integer.valueOf(id));
                frame.dispose();
                new VehiclePaneUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to Delete.");
            }
        });



        frame.setLayout(new GridLayout(1,0,150,5));

        frame.add(jPanel);
        frame.add(actionButtonPanel);

        frame.setSize(1500,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
