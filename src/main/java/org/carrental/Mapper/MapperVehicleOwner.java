package org.carrental.Mapper;

import org.carrental.domain.VehicleOwner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MapperVehicleOwner<T> {
    List<VehicleOwner> resultSetToList(ResultSet rs) throws SQLException;

    T resultSetToObject(ResultSet res);
}
