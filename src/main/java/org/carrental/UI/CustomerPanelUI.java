package org.carrental.UI;

import org.carrental.service.CustomerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomerPanelUI {

    public static void main(String[] args) {
        new CustomerPanelUI();
    }




    private final CustomerService customerService = new CustomerService();
    public CustomerPanelUI(){
        JFrame frame = new JFrame("Customer Panel");

        JPanel jPanel = new JPanel();

        frame.setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));

        JTextField textField = new JTextField(30);

        String data[][] = customerService.getAllCustomer();


        String column[] = {"ID", "NAME" , "Phone_Number" , "CNIC" , "ADDRESS" , "REF_PH_NO"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt = new JTable(dtm);
        jt.setBounds(33,40,250,250);
        JScrollPane sp = new JScrollPane(jt);

        jPanel.add(textField);
        jPanel.add(sp);

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String[][] data = customerService.Service(textField.getText());
                DefaultTableModel dtm = new DefaultTableModel(data,column);
                jt.setModel(dtm);
            }
        });




        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addCustomerButton = new JButton("ADD");
        JButton editCustomerButton = new JButton("EDIT");
        JButton deleteCustomerButton = new JButton("DELETE");
        JButton back = new JButton("BACK");

        back.addActionListener(e->{
            frame.dispose();
            new HomeUi();
        });



        actionButtonPanel.add(addCustomerButton);
        actionButtonPanel.add(editCustomerButton);
        actionButtonPanel.add(deleteCustomerButton);
        actionButtonPanel.add(back);

        addCustomerButton.addActionListener(e->{
            frame.dispose();
            new CustomerAddUI();
        });

        editCustomerButton.addActionListener(e -> {
            if (jt.getSelectedRow() >= 0) {
                String id = (String) jt.getValueAt(jt.getSelectedRow(), 0);
                String name = (String) jt.getValueAt(jt.getSelectedRow(), 1);
                String phoneNo = (String) jt.getValueAt(jt.getSelectedRow(), 2);
                String cnic = (String) jt.getValueAt(jt.getSelectedRow(), 3);
                String address = (String) jt.getValueAt(jt.getSelectedRow(), 4);
                String refNo = (String) jt.getValueAt(jt.getSelectedRow(), 5);
                frame.dispose();
                new CustomerEdit(id, name, phoneNo, cnic, address, refNo);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select the field");
            }
        });

        deleteCustomerButton.addActionListener(e -> {
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {

                String id = (String) jt.getValueAt(selectedRow, 0);
                customerService.deleteCustomer(id);
                frame.dispose();
                new CustomerPanelUI();
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
