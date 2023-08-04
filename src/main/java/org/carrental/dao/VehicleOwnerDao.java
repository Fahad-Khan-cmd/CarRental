package org.carrental.dao;

import org.carrental.Mapper.VehicleOwnerMapper;
import org.carrental.domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VehicleOwnerDao extends BaseDAO implements CRUD<VehicleOwner>{

        VehicleOwnerMapper vehicleOwnerMapper = new VehicleOwnerMapper();
    @Override
    public void insert(VehicleOwner obj) {

        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryVehicleOwner.Insert_Into_VOWNER);
            ps.setString(1,obj.getV_name());
            ps.setString(2,obj.getPhoneNumber());
            ps.setString(3,obj.getCnic());
            ps.setString(4,obj.getAddress());
            ps.setFloat(5,obj.getCommission());
            ps.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void insert(Vehicle obj) {

    }

    @Override
    public void insert(Booking obj) {

    }

    @Override
    public List<VehicleOwner> getAll() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SqlQueryVehicleOwner.Get_ALl_VOWNER);
            return vehicleOwnerMapper.resultSetToList(rs);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void update(VehicleOwner obj, Long id) {

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
        try{
            PreparedStatement ps = conn.prepareStatement(SqlQueryVehicleOwner.Delete_From_VehicleOwner);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getByName(String Name) {
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
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryVehicleOwner.UPDATE_INTO_VEHICLEOWNER);
            ps.setString(1,obj.getV_name());
            ps.setString(2,obj.getPhoneNumber());
            ps.setString(3,obj.getCnic());
            ps.setString(4,obj.getAddress());
            ps.setFloat(5,obj.getCommission());
            ps.setInt(6,id);
            ps.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking obj, Integer id) {

    }
}
