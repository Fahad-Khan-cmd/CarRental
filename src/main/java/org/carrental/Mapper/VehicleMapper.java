package org.carrental.Mapper;

import org.carrental.domain.Booking;
import org.carrental.domain.Customer;
import org.carrental.domain.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMapper implements IMapper<Vehicle> {

    private final static String ID = "id";
    private final static String VNAME = "v_name";
    private final static String VYEAR = "v_year";
    private final static String MODEL = "model";
    private final static String BRAND = "brand";
    private final static String COLOR = "color";
    private final static String OID = "o_id";
    private final static String OWNERNAME = "v_name";

    private final static String OwnerName = "vo.v_name";
    @Override
    public List<Vehicle> resultSetToList(ResultSet rs) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<>();
        while (rs.next()){
            Vehicle vehicle = Vehicle.builder()
                    .id(rs.getInt(ID))
                    .vehicleName(rs.getString(VNAME))
                    .vehicleYear(rs.getInt(VYEAR))
                    .vehiclemodel(rs.getInt(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .vehOwnerName(rs.getString(OwnerName))
                    .build();
            vehicleList.add(vehicle);

        }
        return vehicleList;

    }
    @Override
    public List<Vehicle> resultSetToListForDropDown(ResultSet rs) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<>();
        while (rs.next()){
            Vehicle vehicle = Vehicle.builder()
                    .id(rs.getInt(ID))
                    .vehicleName(rs.getString(VNAME))
                    .vehicleYear(rs.getInt(VYEAR))
                    .vehiclemodel(rs.getInt(MODEL))
                    .brand(rs.getString(BRAND))
                    .color(rs.getString(COLOR))
                    .oid(rs.getInt(OID))
                    .build();
            vehicleList.add(vehicle);

        }
        return vehicleList;

    }

    @Override
    public Vehicle resultSetToObject(ResultSet res) throws SQLException {

        if (res.next()) {
            return Vehicle.builder()
                    .id(res.getInt(ID))
                    .vehicleName(res.getString(VNAME))
                    .vehicleYear(Integer.valueOf(VYEAR))
                    .vehiclemodel(res.getInt(MODEL))
                    .brand(res.getString(BRAND))
                    .color(res.getString(COLOR))
                    .oid(res.getInt(OID))
                    .build();
        }
        return null;
    }
}
