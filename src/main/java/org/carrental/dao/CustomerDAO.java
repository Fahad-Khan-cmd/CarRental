package org.carrental.dao;

import org.carrental.Mapper.CustomerMapper;
import org.carrental.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends BaseDAO implements CRUD<Customer>{
    private final CustomerMapper customerMapper = new CustomerMapper();

    @Override
    public void insert(Customer obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.INSERT_INTO_Customer);
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getPhoneNumber());
            ps.setString(3,obj.getCnic());
            ps.setString(4,obj.getAddress());
            ps.setString(5,obj.getRefPhoneNumber());

            ps.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Vehicle obj) {

    }

    @Override
    public void insert(Booking obj) {

    }

    @Override
    public List<Customer> getAll() {
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(SqlQueryConstant.Get_All_Customer);
            return customerMapper.resultSetToList(res);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }



    @Override
    public Customer getById(Long id) {
        try{
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.Get_By_ID);
            ps.setInt(1,id.intValue());
            ResultSet rs = ps.executeQuery();
            return customerMapper.resultSetToObject(rs);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void update(Customer obj, Long id) {
//
//    }

    @Override
    public void update(Customer obj) {

    }

    @Override
    public void update(Customer obj, Integer id) {

    }

    @Override
    public void update(Vehicle obj, Integer id) {

    }




    @Override
    public void update(Customer obj, Long id) {

        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.UPDATE_CUSTOMER_BY_ID);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPhoneNumber());
            ps.setString(3, obj.getCnic());
            ps.setString(4, obj.getAddress());
            ps.setString(5, obj.getRefPhoneNumber());
            ps.setLong(6,id );

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.DELETE_CUSTOMER_BY_ID);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Customer> getByName(String name) {
        try{
            PreparedStatement ps = conn.prepareStatement("select * from customer where c_name like '%"+name+"%'");
           // ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            return customerMapper.resultSetToList(rs);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User customer) {

    }

    @Override
    public void update(VehicleOwner obj) {

    }

    @Override
    public void update(VehicleOwner obj, Integer id) {

    }

    @Override
    public void update(Booking obj, Integer id) {

    }

//    @Override
//    public void update(Customer customer) {
//        try {
//            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.UPDATE_TABLE);
//            ps.setInt(1,customer.getId().intValue());
//            ps.setString(2,customer.getName());
//            ps.setString(3,customer.getCnic());
//            ps.setString(4,customer.getPhoneNumber());
//            ps.setString(5,customer.getAddress());
//            ps.setString(6,customer.getRefPhoneNumber());
//            ps.executeUpdate();
//
//        }catch (SQLException e){
//                throw new RuntimeException(e);
//        }
//
//    }


}
