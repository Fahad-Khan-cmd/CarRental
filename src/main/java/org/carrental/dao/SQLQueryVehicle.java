package org.carrental.dao;

public class SQLQueryVehicle {

    public final static String GET_ALL_VEHICLE ="select v.id,v.v_name,v.v_year,v.model,v.brand,v.color, vo.v_name from vehicle v Inner Join vehicle_owner vo on v.o_id = vo.id ";
    public final static String INSERT_INTO_VEHICLE= "insert into vehicle(v_name,v_year,model,brand,color,o_id) values(?,?,?,?,?,?)";
    public final static String DELETE_Vehicle_BY_ID = "delete from vehicle where id = ?";

    public final static String Update_Into_Vehicle  = "update vehicle set v_name = ? ,v_year = ? , model=? , brand=? , color=? , o_id=? where id = ?";

    public final static String GET_VEHICLES_BY_START_END_DATE = "select * from vehicle";

    public final static String Get_Vehicle_Active = "select * from vehicle where v_name  In (SELECT v.v_name \n" +
            "    FROM vehicle AS v\n" +
            "    INNER JOIN booking AS b ON v.id = b.vid\n" +
            "    WHERE booking_status = 'active');";

}
