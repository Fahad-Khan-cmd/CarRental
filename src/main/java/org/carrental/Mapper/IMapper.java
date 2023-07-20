package org.carrental.Mapper;

import org.carrental.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public interface IMapper<T> {

    List<Customer> resultSetToList(ResultSet rs) throws SQLException;


    T resultSetToObject(ResultSet res) throws SQLException;
}
