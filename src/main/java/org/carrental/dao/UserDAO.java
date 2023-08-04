package org.carrental.dao;

import org.carrental.Mapper.IMapper;
import org.carrental.Mapper.UserMapper;
import org.carrental.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends BaseDAO implements CRUD<User> {


        private final IMapper<User> userMapper = new UserMapper();
    public User getUserNameAndPassword(String username , String password){
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.USER_NAME_PASSWORD_FROM_USER);
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet res = ps.executeQuery();
            return userMapper.resultSetToObject(res);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(User obj) {

    }

    @Override
    public void insert(Vehicle obj) {

    }

    @Override
    public void insert(Booking obj) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void update(User obj, Long id) {

    }

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
    public void deleteById(Long id) {

    }

    @Override
    public List<Customer> getByName(String name) {
        return null;
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
//
//    }
}
