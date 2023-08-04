package org.carrental.UI;

import javax.swing.*;
import java.awt.*;

public class HomeUi {
    public static void main(String[] args) {
        new HomeUi();
    }
    public HomeUi(){
        JFrame jFrame = new JFrame("Car Rental App - Home");

        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JButton customerBtn = new JButton();
        addImageButton(customerBtn, "src/main/resources/customer-icon.png", 100 ,100);

        customerBtn.addActionListener(e->{
            jFrame.dispose();
            new CustomerPanelUI();
        });

        JButton vehicleBtn = new JButton();
        addVehicleImage(vehicleBtn,"src/main/resources/car-vehicle-insurance-icon.png",100,100);
        vehicleBtn.addActionListener(e -> {
            jFrame.dispose();
            new VehiclePaneUI();
        });

        JButton bookingBtn = new JButton();
        addBookingImage(bookingBtn,"src/main/resources/booking.png",100,100);
        bookingBtn.addActionListener(e->{
            jFrame.dispose();
            new BookingUI();
        });

        JButton vehicleOwnerBtn = new JButton();
        addVehicleOwnerImage(vehicleOwnerBtn,"src/main/resources/automobile-salesman.png",100,100);
        vehicleOwnerBtn.addActionListener(e->{
            jFrame.dispose();
            new VehicleOwnerPanelUI();
        });

        JButton report = new JButton();
        addReportImage(report,"src/main/resources/report.png",100,100);
        report.addActionListener(e->{
            jFrame.dispose();
            new ReportUI();
        });


        jFrame.add(customerBtn);
        jFrame.add(vehicleBtn);
        jFrame.add(bookingBtn);
        jFrame.add(vehicleOwnerBtn);
        jFrame.add(report);

        jFrame.setSize(1500,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }

    private void addVehicleOwnerImage(JButton vehicleOwnerBtn, String s, int i, int i1) {
        ImageIcon imageIcon = new ImageIcon(s);
        Image image = imageIcon.getImage().getScaledInstance(i1,i,Image.SCALE_SMOOTH);
        vehicleOwnerBtn.setIcon(new ImageIcon(image));
    }

    private void addBookingImage(JButton bookingBtn, String s, int i, int i1) {
        ImageIcon imageIcon = new ImageIcon(s);
        Image image = imageIcon.getImage().getScaledInstance(i1,i,Image.SCALE_SMOOTH);
        bookingBtn.setIcon(new ImageIcon(image));
    }


    private void addVehicleImage(JButton vehicleBtn, String pathFromContentRoot, int i, int i1) {
        ImageIcon imageIcon = new ImageIcon(pathFromContentRoot);
        Image image = imageIcon.getImage().getScaledInstance(i1,i,Image.SCALE_SMOOTH);
        vehicleBtn.setIcon(new ImageIcon(image));
    }

    private void addImageButton(JButton customerBtn, String imagepath, int i, int i1) {

        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image image = imageIcon.getImage().getScaledInstance(i1,i,Image.SCALE_SMOOTH);
        customerBtn.setIcon(new ImageIcon(image));

    }
    private void addReportImage(JButton report,String imagepath, int i, int i1 ){
        ImageIcon imageIcon = new ImageIcon(imagepath);
        Image image = imageIcon.getImage().getScaledInstance(i1,i,Image.SCALE_SMOOTH);
        report.setIcon(new ImageIcon(image));

    }


}
