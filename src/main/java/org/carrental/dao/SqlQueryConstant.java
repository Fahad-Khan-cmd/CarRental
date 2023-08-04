package org.carrental.dao;

public class SqlQueryConstant {

    public final static String Get_All_Customer= "select * from customer";
    public final static String INSERT_INTO_Customer= "Insert into customer( c_name , phone_number , cnic , address , ref_phonenumber ) values (?, ? , ? , ? , ? )";

    public final static String Get_By_ID= "select * from customer where id = ?";

    public final static String UPDATE_CUSTOMER_BY_ID = "update customer set c_name = ?,phone_number=?,cnic=?,address=?,ref_phonenumber=? where id = ?";
    public final static String DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";

    public final static String USER_NAME_PASSWORD_FROM_USER = "select * from User where username = ? AND pass = ?";
    //public final static String Get_By_Name= ;

    // public final static String UPDATE_TABLE = "UPDATE customer SET c_name=? , phone_number=? , cnic=? , address=? , ref_phonenumber=? WHERE id=?";

    //  public final static String Delete_By_ID = "DELETE FROM customer WHERE id =? ";

    public final static String Get_All_Vehicle_Active ="SELECT v.v_name , c.c_name FROM vehicle AS v\n" +
            "    INNER JOIN booking AS b ON v.id = b.vid inner join customer AS c on b.cid = c.id\n" +
            "    WHERE booking_status = 'active';";

    public final static String Get_All_Customer_Active ="select * from customer where c_name In (SELECT c.c_name \n" +
            "    FROM customer AS c\n" +
            "    INNER JOIN booking AS b ON b.cid = c.id\n" +
            "    WHERE booking_status = 'active');";


    public final static String  GET_ALL_BOOKING_FROM_START_DATE_AND_END_DATE= "SELECT\n" +
            "    b.id, c.c_name, v.v_name, b.booking_date, b.complete_date,\n" +
            "    (b.price * DATEDIFF(b.complete_date, b.booking_date)) AS price,\n" +
            "    o.commission, b.booking_status\n" +
            "FROM booking b\n" +
            "INNER JOIN customer c ON b.cid = c.id\n" +
            "INNER JOIN vehicle v ON b.vid = v.id\n" +
            "INNER JOIN vehicle_owner o ON v.o_id = o.id\n" +
            "WHERE b.booking_date BETWEEN ? AND ?;\n";

    public static final String TOTAL_PROFIT = "SELECT\n" +
            "    SUM(b.price * DATEDIFF(b.complete_date, b.booking_date)) - SUM(b.price * DATEDIFF(b.complete_date, b.booking_date) * COALESCE(o.commission, 0) / 100) AS profit\n" +
            "FROM booking b\n" +
            "INNER JOIN vehicle v ON b.vid = v.id\n" +
            "LEFT JOIN vehicle_owner o ON v.o_id = o.id\n" +
            "WHERE b.booking_date BETWEEN ? AND ?;\n";

    public static final String TOTAL_PRICE = "SELECT SUM(price * DATEDIFF(complete_date, booking_date)) AS price FROM booking WHERE booking_date BETWEEN ? AND ? ;";

    public static final String TOTAL_COMMISTION = "SELECT\n" +
            "    SUM(b.price * DATEDIFF(b.complete_date, b.booking_date) * COALESCE(o.commission, 0) / 100) AS total_commission\n" +
            "FROM booking b\n" +
            "INNER JOIN vehicle v ON b.vid = v.id\n" +
            "LEFT JOIN vehicle_owner o ON v.o_id = o.id\n" +
            "WHERE b.booking_date BETWEEN ? AND ?;\n";
    public static final String COMISSION_REPORT = "select o.v_name, o.commission*(DATEDIFF(b.complete_date , b.booking_date) \n" +
            "*b.price)/100 as owner_comission, v.v_name from vehicle_owner o \n" +
            "inner join vehicle v on o.id = v.o_id inner join booking b on v.id = b.vid where b.complete_date between ? and ? and b.booking_status = 'Complete';";

    public static final String  COMMISION_PERCENT= "select o.commission from vehicle_owner o inner join vehicle v on o.id = v.o_id inner join booking b on v.id = b.vid where b.booking_date between ? and ? and b.booking_status = 'Complete'";


}

