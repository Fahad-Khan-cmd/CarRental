package org.carrental.dao;

import org.carrental.Mapper.VehicleMapper;
import org.carrental.domain.*;

import java.sql.*;
import java.util.List;

public class VehicleDao extends BaseDAO implements CRUD<Vehicle>{

    private final VehicleMapper vehicleMapper = new VehicleMapper();

    @Override
    public void insert(Vehicle obj) {
        try {
        PreparedStatement ps = conn.prepareStatement(SQLQueryVehicle.INSERT_INTO_VEHICLE);
        ps.setString(1,obj.getVehicleName());
        ps.setInt(2, obj.getVehicleYear());
        ps.setInt(3,obj.getVehiclemodel());
        ps.setString(4,obj.getBrand());
        ps.setString(5,obj.getColor());
        ps.setInt(6,obj.getOid());
        ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Booking obj) {


    }

    @Override
    public List<Vehicle> getAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQLQueryVehicle.GET_ALL_VEHICLE);
            return vehicleMapper.resultSetToList(rs);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void update(Vehicle obj, Long id) {

    }

//    @Override
//    public void update(Object obj, Long id) {
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
        try {
            PreparedStatement ps = conn.prepareStatement(SQLQueryVehicle.Update_Into_Vehicle);
            ps.setString(1,obj.getVehicleName());
            ps.setInt(2,obj.getVehicleYear());
            ps.setInt(3,obj.getVehiclemodel());
            ps.setString(4,obj.getBrand());
            ps.setString(5,obj.getColor());
            ps.setInt(6,obj.getOid());
            ps.setInt(7,id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteById(Long id) {
        try{
            PreparedStatement ps = conn.prepareStatement(SQLQueryVehicle.DELETE_Vehicle_BY_ID);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List getByName(String vehicleName) {
        try{

            PreparedStatement ps = conn.prepareStatement("select * from vehicle where c_name like '%"+vehicleName+"%'");

            ResultSet rs = ps.executeQuery();
            return vehicleMapper.resultSetToList(rs);

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
}
