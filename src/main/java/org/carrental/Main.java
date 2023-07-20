package org.carrental;

import org.carrental.UI.HomeUi;
import org.carrental.UI.LogInUI;
import org.carrental.dao.CustomerDAO;
import org.carrental.domain.Customer;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


       public static void main(String[] args) {
//           CustomerDAO customerDAO = new CustomerDAO();
//           Customer newCus = Customer.builder()
//
//                   .name("Wahab")
//                   .phoneNumber("0344123511")
//                   .cnic("4230134051")
//                   .address("Lahore Hill Area")
//                   .refPhoneNumber("412351325sd")
//
//
//
//                   .build();
//
//           Customer customer = customerDAO.getById(11L);
//           customer.setName("Hammad");
//           customerDAO.update(customer,11L);
//           System.out.println(customerDAO.getById(11L));
//           customerDAO.deleteById(11L);
//
//            System.out.println(customerDAO.getAll());
          // LogInUI obj = new LogInUI();
            new HomeUi();
        }

}
