package org.carrental.dao;

public class SqlQueryVehicleOwner {

    public static final String Get_ALl_VOWNER= "select * from vehicle_owner";

    public static final String UPDATE_INTO_VEHICLEOWNER = "update vehicle_owner set v_name = ?,cnic=?,phone_number=?,address=?, commission=? where id = ?";

    public static final String Insert_Into_VOWNER = "insert into vehicle_owner(v_name,cnic,phone_number,address,commission) values(?,?,?,?,?)";

    public final static String Delete_From_VehicleOwner = "delete from vehicle_owner where id = ?";

}
