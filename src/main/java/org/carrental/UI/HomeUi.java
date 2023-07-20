package org.carrental.UI;

import javax.swing.*;
import java.awt.*;

public class HomeUi {
    public HomeUi(){
        JFrame jFrame = new JFrame("Car Rental App - Home");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("2"));
        jPanel.add(new JButton("3"));
        jPanel.add(new JButton("4"));


        JPanel tablepanel = new JPanel();
        tablepanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        String data[][] = {
                {"101", "Fahad" , "7500"},
                {"102", "Wahab" , "8500"},
                {"103", "Hammad" ,"9500"},
        };
        String column[] = {"ID" , "NAME" , "SALARY"};
        JTable jt = new JTable(data,column);
        JScrollPane sp = new JScrollPane(jt);
        tablepanel.add(sp);

        jFrame.setLayout(new BorderLayout(10,50));

        jFrame.add(jPanel, BorderLayout.SOUTH);

        jFrame.add(tablepanel, BorderLayout.CENTER);
        jFrame.add(new JButton("Hello"), BorderLayout.NORTH);

        jFrame.setSize(1500,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
