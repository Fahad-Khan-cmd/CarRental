package org.carrental.UI;

import com.toedter.calendar.JDateChooser;
import org.carrental.service.BookingService;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingCloseUI {


    BookingService bookingService = new BookingService();
    public BookingCloseUI(String id, String cid, String vid, String bookingDate, String price, String  bookingStatus, String cName, String vName, String completeDate ) throws ParseException {

        JFrame frame = new JFrame("Rental Car App | Add Booking");
        frame.setLayout(new GridLayout(12, 10, 10, 30));


//        JLabel startDate = new JLabel("Start Date");
//        JDateChooser jDateChooser1 = new JDateChooser();
//
//        JLabel endDate = new JLabel("End Date");
//        JDateChooser jDateChooser2 = new JDateChooser();

        JLabel customerActive = new JLabel("Customer");
        String[] customerIdOptions =bookingService.getCustomerActive();
        JComboBox<String> dropdownCustomerId = new JComboBox<>(customerIdOptions);
        //dropdownCustomerId.getModel().setSelectedItem(cid);
        //dropdownCustomerId.getModel().setSelectedItem(cName);

        JLabel vehicleIdLbl = new JLabel("Vehicle ID");
        String[] vehicleIdOptions = bookingService.getVehicleActive();
        JComboBox<String> dropdownvehicleId = new JComboBox<>(vehicleIdOptions);
        //dropdownvehicleId.getModel().setSelectedItem(vid);
        //dropdownvehicleId.getModel().setSelectedItem(vName);




        JLabel date = new JLabel("Date");
        JDateChooser jDateChooser = new JDateChooser();
        //jDateChooser.setDate(bookingDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date bookingDatestr = dateFormat.parse(bookingDate);

        // Now, you have the bookingDate as a Date object.
        // Set the value to the JDateChooser:
        jDateChooser.setDate(bookingDatestr);


        JLabel amount = new JLabel("Amount");
        JTextField amountTf = new JTextField(20);
        amountTf.setText(price);

        JLabel book = new JLabel("Booking");
        String[] status = {"Complete"};
        JComboBox<String > dropdownBookingStatus = new JComboBox<>(status);
        //JTextField jTextb = new JTextField(20);


        JButton back = new JButton("BACK");
        JButton save = new JButton("Update");

        frame.add(vehicleIdLbl);
        frame.add(dropdownvehicleId);

        frame.add(customerActive);
        frame.add(dropdownCustomerId);

        frame.add(date);
        frame.add(jDateChooser);

        frame.add(amount);
        frame.add(amountTf);

        frame.add(book);
        frame.add(dropdownBookingStatus);
        //frame.add(jTextb);

        frame.add(back);
        frame.add(save);

        back.addActionListener(e->{
            frame.dispose();
            new BookingUI();
        });

        save.addActionListener(e -> {
            String inputVehicle = (String) dropdownvehicleId.getSelectedItem();
            String[] partsVehicle = inputVehicle.split(",");
            Integer vehicleId = Integer.valueOf(partsVehicle[0]);

            String inputCustomer = (String) dropdownCustomerId.getSelectedItem();
            String[] partsCustomer = inputCustomer.split(",");
            Integer customerId = Integer.valueOf(partsCustomer[0]);

            String bookingStatuss = (String) dropdownBookingStatus.getSelectedItem();


            //String partsBookingStatus = (String) dropdownBookingStatus.getSelectedItem();
//            //String[] partsBooking = partsBookingStatus.split(",");
//            String BookingStatus = String.valueOf(partsBookingStatus);

            bookingService.updateBooking(Integer.valueOf(id),customerId, vehicleId,  jDateChooser.getDate(), Double.valueOf(amountTf.getText()), bookingStatuss);
            frame.dispose();
            new BookingUI();

        });



        frame.setSize(500, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



    }

}
