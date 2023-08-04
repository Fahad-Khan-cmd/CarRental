package org.carrental.service;

import org.carrental.dao.CustomerDAO;
import org.carrental.domain.Customer;

import java.util.List;

public class CustomerService {

    CustomerDAO dao = new CustomerDAO();



    public String[][] Service(String name){
        List<Customer> customerList = dao.getByName(name);
        return transformToJTable(customerList,7);
    }
    public String[][] getAllCustomer(){
        List<Customer> customerList = dao.getAll();
        return transformToJTable(customerList,7);

    }

    private String[][] transformToJTable(List<Customer> customerList, int columnSize){
        String[][] data = new String[customerList.size()][columnSize];
        for (int i =0; i<customerList.size(); i++) {
            data[i][0] = String.valueOf(customerList.get(i).getId());
            data[i][1] = customerList.get(i).getName();
            data[i][2] = customerList.get(i).getPhoneNumber();
            data[i][3] = customerList.get(i).getCnic();
            data[i][4] = customerList.get(i).getAddress();
            data[i][5] = customerList.get(i).getRefPhoneNumber();
        }
        System.out.println(data);
        return data;
    }

    public void save(String name, String phone, String cnic, String address, String refPhone) {
            Customer customer = Customer.builder()
                    .name(name)
                    .phoneNumber(phone)
                    .cnic(cnic)
                    .address(address)
                    .refPhoneNumber(refPhone)
                    //  .bookingStatus(bookingStatus)

                    .build();
            dao.insert(customer);
    }

    public void update(String Id , String updatedName, String updatedPhoneNumber, String updatedCnic, String updatedAddress, String updatedRefPhoneNumber) {
        Customer customer = Customer.builder()
    //            .id(id)
                .name(updatedName)
                .phoneNumber(updatedPhoneNumber)
                .cnic(updatedCnic)
                .address(updatedAddress)
                .refPhoneNumber(updatedRefPhoneNumber)
                .build();

        dao.update(customer, Long.valueOf(Id));
    }
    public void deleteCustomer(String id){
        Customer customer = Customer.builder()
                .name(id)
                .build();


        dao.deleteById(Long.valueOf(id));
    }

    public void getByIdCustomer(Long id){
        Customer customer = Customer.builder()
                .id(id)


                .build();
                dao.getById(customer.getId());

    }


//    public void update(Long updateId, String updatedName, String updatedPhoneNumber, String updatedCnic, String updatedAddress, String updatedRefPhoneNumber) {
//        Customer customer = Customer.builder()
//                .id((long) updateId)
//                .name(updatedName)
//                .phoneNumber(updatedPhoneNumber)
//                .cnic(updatedCnic)
//                .address(updatedAddress)
//                .refPhoneNumber(updatedRefPhoneNumber)
//
//
//                .build();
//        dao.update(customer, customer.getId());
//    }
}

