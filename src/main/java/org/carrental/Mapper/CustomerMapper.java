package org.carrental.Mapper;

import org.carrental.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements IMapper<Customer> {

    private final static String ID = "id";
    private final static String CNAME = "c_name";
    private final static String PhoneNumber = "phone_number";
    private final static String CNIC = "cnic";
    private final static String Address = "address";
    private final static String REFPHONENUM = "ref_phonenumber";

    @Override
    public List<Customer> resultSetToList(ResultSet rs) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        while (rs.next()) {
            Customer customer = Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(CNAME))
                    .phoneNumber(rs.getString(PhoneNumber))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(Address))
                    .refPhoneNumber(rs.getString(REFPHONENUM))
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer resultSetToObject(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return Customer.builder()
                    .id((long) rs.getInt(ID))
                    .name(rs.getString(CNAME))
                    .phoneNumber(rs.getString(PhoneNumber))
                    .cnic(rs.getString(CNIC))
                    .address(rs.getString(Address))
                    .refPhoneNumber(rs.getString(REFPHONENUM))
                    .build();
        }
        return null;
    }
}