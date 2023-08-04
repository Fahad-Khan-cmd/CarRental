package org.carrental.dao;

public class SQLQueryBooking {

    public static final String Get_All_Booking ="select b.id, b.cid, b.vid, b.booking_date,  b.price,b.booking_status, b.complete_date ,c.c_name, v.v_name from booking b inner join customer c on b.cid = c.id inner join vehicle v on b.vid = v.id ";
    public static final String POST = "insert into booking(cid,vid,booking_date,price,booking_status) values(?,?,?,?,?)";
    // public static final String Insert_Into_Booking =public final static String INSERT_INTO_Customer= "Insert into customer("
    public final static String INSERT_INTO_Booking= "Insert into booking( cid , vid , booking_date , price , booking_status ,start_date,end_date) values (?, ? , ? , ? , ? ,?,?)";

    public final static String UPDATE_VEHICLE_STATUS_AFTER_ADD = "UPDATE vehicle SET status = 'Booked' WHERE id = ?";

    public final static String UPDATE_BOOKING = "UPDATE booking\n" +
            "SET cid = ?, vid = ?, complete_date = ?, price = ?, booking_status = ?\n" +
            "WHERE id = ?;";
}
