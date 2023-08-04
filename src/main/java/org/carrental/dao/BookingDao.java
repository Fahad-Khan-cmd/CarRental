package org.carrental.dao;

import org.carrental.Mapper.BookingMapper;
import org.carrental.Mapper.CustomerMapper;
import org.carrental.Mapper.VehicleMapper;
import org.carrental.domain.*;

import java.sql.*;
import java.util.List;

public class BookingDao extends BaseDAO implements CRUD{

    private final BookingMapper bookingMapper = new BookingMapper();
    private final VehicleMapper vehicleMapper = new VehicleMapper();
    private final CustomerMapper customerMapper = new CustomerMapper();
    @Override
    public void insert(Object obj) {

    }

    @Override
    public void insert(Vehicle obj) {

    }

    @Override
    public void insert(Booking obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(SQLQueryBooking.INSERT_INTO_Booking);
            ps.setInt(1,obj.getCid());
            ps.setInt(2,obj.getVid());
            ps.setDouble(3,obj.getPrice());
            ps.setDate(4, (Date) obj.getBooking_date());
            ps.setString(5,obj.getBooking_status());
//            ps.setDate(6, (Date) obj.getStart_date());
//            ps.setDate(7,(Date) obj.getEnd_date());

            ps.executeUpdate();



        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getAll() {

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQLQueryBooking.Get_All_Booking);
            return bookingMapper.resultSetToList(rs);


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
//
//    public List<Vehicle> getAllVehicles() {
//        try {
//            // Convert java.util.Date to java.sql.Date
////            java.sql.Date sqlStartDate = new java.sql.Date(start_date.getTime());
////            java.sql.Date sqlEndDate = new java.sql.Date(end_Date.getTime());
//            PreparedStatement ps = conn.prepareStatement(SQLQueryVehicle.GET_VEHICLES_BY_START_END_DATE);
//            ps.setDate(1,sqlStartDate);
//            ps.setDate(2,sqlEndDate);
//            ps.setDate(3,sqlStartDate);
//            ps.setDate(4,sqlEndDate);
//            ResultSet rs = ps.executeQuery();
//            return vehicleMapper.resultSetToListForDropDown(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Vehicle> getAllVehicles(){
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQLQueryVehicle.GET_VEHICLES_BY_START_END_DATE);
            return vehicleMapper.resultSetToListForDropDown(rs);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public List<Vehicle> getAllVehiclesActives(){
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQLQueryVehicle.Get_Vehicle_Active);
            return vehicleMapper.resultSetToListForDropDown(rs);


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomersActives(){
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SqlQueryConstant.Get_All_Customer_Active);
            return customerMapper.resultSetToList(rs);


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomer() {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer");
            return customerMapper.resultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getByDate(String date) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from booking where booking_date like '%" + date + "%' and status != 'Inactive'");
            ResultSet resultSet = ps.executeQuery();
            return bookingMapper.resultSetToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void update(Object obj, Long id) {

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
            PreparedStatement ps = conn.prepareStatement("delete from booking where id = ?");
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

    }

    @Override
    public void update(Booking obj, Integer id) {
       java.sql.Date sqlDate = new java.sql.Date(obj.getComplete_date().getTime());
        try {
            PreparedStatement ps = conn.prepareStatement(SQLQueryBooking.UPDATE_BOOKING);
            ps.setInt(1,obj.getCid());
            ps.setInt(2,obj.getVid());
            ps.setDate(3,  sqlDate);
            ps.setDouble(4,obj.getPrice());
            ps.setString(5,obj.getBooking_status());
            ps.setInt(6,id);
            ps.executeUpdate();
        }catch (SQLException e){
                throw new RuntimeException(e);
        }

    }


    public void post(Booking obj) {
        try {
//            java.sql.Date sqlStartDate = new java.sql.Date(obj.getStart_date().getTime());
//            java.sql.Date sqlEndDate = new java.sql.Date(obj.getEnd_date().getTime());
            PreparedStatement ps = conn.prepareStatement(SQLQueryBooking.POST);
            ps.setInt(1, obj.getCid());
            ps.setInt(2, obj.getVid());
            ps.setDate(3, (Date) obj.getBooking_date());
            ps.setDouble(4, obj.getPrice());
//            ps.setDate(5, sqlStartDate);
//            ps.setDate(6, sqlEndDate);
            ps.setString(5,obj.getBooking_status());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateVehicleStatusAdd(Integer id) {
        try {
            PreparedStatement statement = conn.prepareStatement(SQLQueryBooking.UPDATE_VEHICLE_STATUS_AFTER_ADD);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
