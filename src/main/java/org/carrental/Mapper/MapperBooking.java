package org.carrental.Mapper;

import org.carrental.domain.Booking;
import org.carrental.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MapperBooking<T> {

    List<Booking> resultSetToList(ResultSet rs) throws SQLException;


    T resultSetToObject(ResultSet res);


}
