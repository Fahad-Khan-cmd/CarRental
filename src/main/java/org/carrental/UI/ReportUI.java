package org.carrental.UI;

import javax.swing.*;
import java.awt.*;

public class ReportUI {

    public static void main(String[] args) {
        new ReportUI();
    }
    public ReportUI(){
        JFrame frame = new JFrame("Car Rental Reports");
        frame.setLayout(new GridLayout(10,10,10,10));
        //frame.getContentPane().setBackground(new Color(52, 73, 94));


        JButton monthlyRepBtn = new JButton("Monthly Report");
        JButton commissionRepBtn = new JButton("Commission Report");
        JButton carAvailabilityRepBtn = new JButton("Car Availability Report");
        JButton backBtn = new JButton("Back Button");

        frame.add(monthlyRepBtn);
        frame.add(commissionRepBtn);
        frame.add(carAvailabilityRepBtn);
        frame.add(backBtn);

        // Add action listeners
        monthlyRepBtn.addActionListener(event -> {
            frame.dispose();
            new MonthlyReportUI();
        });

        commissionRepBtn.addActionListener(event -> {
            frame.dispose();
            new CommissionReport();
        });

        carAvailabilityRepBtn.addActionListener(event -> {
            frame.dispose();
            new CarAvailabilityReport();
        });

        backBtn.addActionListener(event -> {
            frame.dispose();
            new HomeUi();
        });

        frame.setSize(1100, 650);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
