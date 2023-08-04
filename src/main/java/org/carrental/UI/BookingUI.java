package org.carrental.UI;

import org.carrental.domain.Booking;
import org.carrental.service.BookingService;
import org.carrental.service.CustomerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;

public class BookingUI {

    public static void main(String[] args) {
        new BookingUI();
    }
    private final BookingService bookingService = new BookingService();



    public BookingUI(){

        JFrame frame = new JFrame("Booking Panel");

        JPanel jPanel = new JPanel();

        frame.setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        JTextField textField = new JTextField(30);

        String data[][] = bookingService.getAllBooking();


        String column[] = {"ID", "CID" , "VID" , "PRICE" ,   "Booking_Date" ,"Complete_Date" ,"CNAME","VNAME", "BookingStatus"};

        DefaultTableModel dtm = new DefaultTableModel(data,column);
        JTable jt = new JTable(dtm);
        jt.setBounds(33,40,500,500);
        JScrollPane sp = new JScrollPane(jt);

        jPanel.add(textField);
        jPanel.add(sp);



        JPanel actionButtonPanel = new JPanel();
        actionButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        JButton addBookingButton = new JButton("ADD Booking");
        JButton editBookingButton = new JButton("Edit Booking");
        JButton CloseBookingButton = new JButton("Close Booking");
        JButton deleteBookingButton = new JButton("DeleteBooking");

        deleteBookingButton.addActionListener(e -> {
            int selectedRow = jt.getSelectedRow();
            if (selectedRow != -1) {

                String id = (String) jt.getValueAt(selectedRow, 0);
                bookingService.deleteCustomer(id);
                frame.dispose();
                new BookingUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to Delete.");
            }
        });
        JButton back = new JButton("BACK");

        back.addActionListener(e->{
            frame.dispose();
            new HomeUi();
        });



        actionButtonPanel.add(addBookingButton);
//        actionButtonPanel.add(editBookingButton);
        actionButtonPanel.add(CloseBookingButton);
        actionButtonPanel.add(back);
        actionButtonPanel.add(deleteBookingButton);

        addBookingButton.addActionListener(e->{
            frame.dispose();
            new BookingAddUI();
        });

        CloseBookingButton.addActionListener(e->{
            if (jt.getSelectedRow() >= 0) {
                String id = (String) jt.getValueAt(jt.getSelectedRow(), 0);
                String cid = (String) jt.getValueAt(jt.getSelectedRow(), 1);
                String vid = (String) jt.getValueAt(jt.getSelectedRow(), 2);
                String price = (String) jt.getValueAt(jt.getSelectedRow(), 3);
                String bookingDate = (String) jt.getValueAt(jt.getSelectedRow(), 4);
                String bookingStatus = (String) jt.getValueAt(jt.getSelectedRow(), 5);
                String  cName = (String) jt.getValueAt(jt.getSelectedRow(),6);
                String   vName = (String) jt.getValueAt(jt.getSelectedRow(),7);
                String   completeDate = (String) jt.getValueAt(jt.getSelectedRow(),8);
//                String  endDate = (String) jt.getValueAt(jt.getSelectedRow(),9);


                frame.dispose();
                try {
                    new BookingCloseUI(id, cid, vid, bookingDate, price,  bookingStatus,cName,vName, completeDate);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select the field");
            }


    });


        frame.setLayout(new GridLayout(1,0,150,10));

        frame.add(jPanel);
        frame.add(actionButtonPanel);

        frame.setSize(2000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}

