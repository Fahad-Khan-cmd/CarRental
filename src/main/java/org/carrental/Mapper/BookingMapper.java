package org.carrental.Mapper;

import org.carrental.domain.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements MapperBooking<Booking>{


    private final static String ID = "id";
    private final static String CUSID= "cid";
    private final static String Vehicle_ID = "vid";
    private final static String BOOKINGDATE = "booking_date";
    private final static String PRICE = "price";
    private final static String Booking_Status = "booking_status";
    private final static String START_DATE = "start_date";
    private final static String END_DATE = "end_date";
    private static final String CUSTOMER_NAME = "c_name";
    private static final String VEHICLE_NAME = "v_name";
    private static final String COMMISSION = "o.commission";
    private static final String COMPLETEDATE = "complete_date";


    @Override
    public List<Booking> resultSetToList(ResultSet rs) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (rs.next()){
            Booking booking = Booking.builder()
                    .id(rs.getInt(ID))
                    .cid(rs.getInt(CUSID))
                    .vid(rs.getInt(Vehicle_ID))
                    .booking_date(rs.getDate(BOOKINGDATE))
                    .price(rs.getDouble(PRICE))
                    .booking_status(rs.getString(Booking_Status))
                    .v_name(rs.getString(CUSTOMER_NAME))
                    .c_name(rs.getString(VEHICLE_NAME))
                    .complete_date(rs.getDate(COMPLETEDATE))
//                    .start_date(rs.getDate(START_DATE))
//                    .end_date(rs.getDate(END_DATE))
                    .build();

                bookings.add(booking);
        }
        return bookings;
    }

    public List<Booking> resultSetToListWithCustomerNameAndVehicleNameAndCommission(ResultSet rs) throws SQLException {
        List<Booking> bookingList = new ArrayList<>();
        while(rs.next()){
            Booking booking = Booking.builder()   //object banaya
                    .id(rs.getInt(ID))
                    .c_name(rs.getString(CUSTOMER_NAME))
                    .v_name(rs.getString(VEHICLE_NAME))
                    .booking_date(rs.getDate(BOOKINGDATE))
                    .complete_date(rs.getDate(COMPLETEDATE))
//                    .end_date(rs.getDate(END_DATE))
                    .price(rs.getDouble(PRICE))
                    .commission(rs.getDouble(COMMISSION))
                    .booking_status(rs.getString(Booking_Status))
                    .build();
            bookingList.add(booking);
        }
        return bookingList;
    }


    @Override
    public Booking resultSetToObject(ResultSet res) {
        return null;
    }
}
