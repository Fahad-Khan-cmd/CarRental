package org.carrental.Mapper;

import org.carrental.domain.Customer;
import org.carrental.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapper implements IMapper<User> {

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASS = "pass";

    @Override
    public List<Customer> resultSetToList(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public User resultSetToObject(ResultSet res) throws SQLException {
        if (res.next()) {
            return User.builder()
                    .id(res.getInt(ID))
                    .username(res.getString(USERNAME))
                    .password(res.getString(PASS))
                    .build();
        }
            return null;
    }

}
