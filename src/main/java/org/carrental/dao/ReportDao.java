package org.carrental.dao;

import org.carrental.Mapper.BookingMapper;
import org.carrental.Mapper.VehicleOwnerMapper;
import org.carrental.domain.Booking;
import org.carrental.domain.VehicleOwner;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReportDao extends BaseDAO{
    private final BookingMapper bookingMapper = new BookingMapper();
    private final VehicleOwnerMapper vehicleOwnerMapper = new VehicleOwnerMapper();
    public List<Booking> getAllBookingsWithStartDateAndEndDate(Date startDate, Date endDate) {
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.GET_ALL_BOOKING_FROM_START_DATE_AND_END_DATE);
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            return bookingMapper.resultSetToListWithCustomerNameAndVehicleNameAndCommission(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error getting all bookings with start and end date.", e);
        }
    }

    public List<VehicleOwner> commissionReport(java.util.Date startDate, java.util.Date endDate) {
        try {
            PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.COMISSION_REPORT);
            statement.setDate(1, new java.sql.Date(startDate.getTime()));
            statement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            return vehicleOwnerMapper.resultToListForCommissionReport(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<VehicleOwner> commissionPercent(java.util.Date startDate, java.util.Date endDate) {
        try {
            PreparedStatement statement = conn.prepareStatement(SqlQueryConstant.COMMISION_PERCENT);
            statement.setDate(1, new java.sql.Date(startDate.getTime()));
            statement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            return vehicleOwnerMapper.commisioinPercentConversion(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Double getTotalProfit(Date bookingDate, Date completeDate){
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.TOTAL_PROFIT);
            ps.setDate(1, new java.sql.Date(bookingDate.getTime()));
            ps.setDate(2, new java.sql.Date(completeDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getDouble(1);
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException("Error getting all profit from start and end date.", e);
        }
    }
    public Double getTotalPrice(Date bookingDate, Date completeDate){
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.TOTAL_PRICE);
            ps.setDate(1, new java.sql.Date(bookingDate.getTime()));
            ps.setDate(2, new java.sql.Date(completeDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getDouble(1);
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException("Error getting all price from start and end date.", e);
        }
    }

    public Double getTotalCommission(Date startDate, Date endDate){
        try {
            PreparedStatement ps = conn.prepareStatement(SqlQueryConstant.TOTAL_COMMISTION);
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException("Error getting all commission from start and end date.", e);
        }
    }

}
