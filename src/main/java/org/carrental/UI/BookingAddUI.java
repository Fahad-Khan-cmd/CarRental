package org.carrental.UI;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import org.carrental.domain.Booking;
import org.carrental.domain.Customer;
import org.carrental.domain.Vehicle;
import org.carrental.service.BookingService;
import org.carrental.service.CustomerService;
import org.carrental.service.VehicleService;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

public class BookingAddUI {

    private final BookingService bookingService = new BookingService();
    private final CustomerService customerService = new CustomerService();
    private final VehicleService vehicleService = new VehicleService();

    public static void main(String[] args) {
        new BookingAddUI();
    }

    public BookingAddUI() {
        JFrame frame = new JFrame("Rental Car App | Add Booking");
        frame.setLayout(new GridLayout(12, 10, 10, 30));

//
//        JLabel startDate = new JLabel("Start Date");
//        JDateChooser jDateChooser1 = new JDateChooser();
//
//        JLabel endDate = new JLabel("End Date");
//        JDateChooser jDateChooser2 = new JDateChooser();

        JLabel customerIdLbl = new JLabel("Customer");
        String[] customerIdOptions =bookingService.getCustomer();
        JComboBox<String> dropdownCustomerId = new JComboBox<>(customerIdOptions);

        JLabel vehicleIdLbl = new JLabel("Vehicle ID");
        String[] vehicleIdOptions = bookingService.getVehicle();
        JComboBox<String> dropdownvehicleId = new JComboBox<>(vehicleIdOptions);

        JLabel date = new JLabel("Date");
        JDateChooser jDateChooser = new JDateChooser();


        JLabel amount = new JLabel("Amount");
        JTextField amountTf = new JTextField(20);

        JButton back = new JButton("BACK");
        JButton save = new JButton("SAVE");
        JButton findVehicles= new JButton("Find Vehicles");
        JButton sdf= new JButton();



        //frame.add(findVehicles);



        frame.add(vehicleIdLbl);
        frame.add(dropdownvehicleId);
        frame.add(customerIdLbl);
        frame.add(dropdownCustomerId);
        frame.add(date);
        frame.add(jDateChooser);
        frame.add(amount);
        frame.add(amountTf);
        frame.add(save);
        frame.add(back);
        back.addActionListener(e -> {
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

            Boolean flag = true;
            if (Integer.valueOf(amountTf.getText()) < 0) {
                JOptionPane.showMessageDialog(frame, "Amount can not be negative = '" + amountTf.getText() + "'");
                flag = false;
                amountTf.setText("");
            } else {
            }
            if (flag) {
                bookingService.add(customerId, vehicleId, jDateChooser.getDate(), Double.valueOf(amountTf.getText()));
                frame.dispose();
                new BookingUI();
            }


        });



        frame.setSize(500, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }



}





