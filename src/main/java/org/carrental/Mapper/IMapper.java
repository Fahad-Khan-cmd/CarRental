package org.carrental.Mapper;

import org.carrental.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMapper<T> {

    List<T> resultSetToList(ResultSet rs) throws SQLException;

    List<T> resultSetToListForDropDown(ResultSet rs) throws SQLException;
    T resultSetToObject(ResultSet res) throws SQLException;



}
