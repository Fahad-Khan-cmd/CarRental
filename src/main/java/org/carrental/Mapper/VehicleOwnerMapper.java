package org.carrental.Mapper;

import org.carrental.domain.Customer;
import org.carrental.domain.Vehicle;
import org.carrental.domain.VehicleOwner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleOwnerMapper implements IMapper<VehicleOwner> {

    private final static String ID = "id";
    private final static String ONAME = "v_name";
    private final static String CNIC = "cnic";
    private final static String PHNUMBER = "phone_number";
    private final static String ADDRESS = "address";
    private final static String COMMISION = "commission";
    private final static String VEHICLENAME = "v.v_name";

    @Override
    public List<VehicleOwner> resultSetToList(ResultSet rs) throws SQLException {
        List<VehicleOwner> vehicleOwnerList = new ArrayList<>();
        while (rs.next()) {
            VehicleOwner vehicleOwner = VehicleOwner.builder()
                    .id(rs.getInt(ID))
                    .v_name(rs.getString(ONAME))
                    .cnic(rs.getString(CNIC))
                    .phoneNumber(rs.getString(PHNUMBER))
                    .address(rs.getString(ADDRESS))
                    .commission(rs.getFloat(COMMISION))
                    .build();
            vehicleOwnerList.add(vehicleOwner);

        }

        return vehicleOwnerList;
    }

    public List<VehicleOwner> commisioinPercentConversion(ResultSet resultSet) throws SQLException {
        List<VehicleOwner> vehicleOwnerList = new ArrayList<>();
        while (resultSet.next()) {
            VehicleOwner vehicleOwner = VehicleOwner.builder()
                    .commission(resultSet.getFloat(COMMISION))
                    .build();
            vehicleOwnerList.add(vehicleOwner);
        }
        return vehicleOwnerList;
    }

    public List<VehicleOwner> resultToListForCommissionReport(ResultSet resultSet) throws SQLException {
        List<VehicleOwner> vehicleOwnerList = new ArrayList<>();
        while (resultSet.next()) {
            VehicleOwner vehicleOwner = VehicleOwner.builder()
                    .v_name(resultSet.getString(ONAME))
                    .vehicle_name(resultSet.getString(VEHICLENAME))
                    .commission(resultSet.getFloat(COMMISION))

                    .build();
            vehicleOwnerList.add(vehicleOwner);
        }
        return vehicleOwnerList;
    }

        @Override
        public List<VehicleOwner> resultSetToListForDropDown (ResultSet rs) throws SQLException {
            return null;
        }

        public VehicleOwner resultSetToObject (ResultSet res) throws SQLException {
            if (res.next()) {
                return VehicleOwner.builder()
                        .id((Integer) res.getInt(ID))
                        .v_name(res.getString(ONAME))
                        .phoneNumber(res.getString(PHNUMBER))
                        .cnic(res.getString(CNIC))
                        .address(res.getString(ADDRESS))
                        .commission(res.getFloat(COMMISION))
                        .build();
            }
            return null;
        }

    }
