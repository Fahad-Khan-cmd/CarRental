package org.carrental.Mapper;

import org.carrental.domain.Customer;
import org.carrental.domain.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMapperVehicle<T> {
    List<Vehicle> resultSetToList(ResultSet rs) throws SQLException;


    T resultSetToObject(ResultSet res) throws SQLException;




}
