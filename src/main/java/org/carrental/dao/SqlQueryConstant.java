package org.carrental.dao;

public class SqlQueryConstant {

    public final static String Get_All_Customer= "select * from customer";
    public final static String INSERT_INTO_Customer= "Insert into customer( c_name , phone_number , cnic , address , ref_phonenumber ) values (?, ? , ? , ? , ? )";

    public final static String Get_By_ID= "select * from customer where id = ?";

    public final static String UPDATE_CUSTOMER_BY_ID = "update customer set c_name = ? where id = ?";
    public final static String DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";

    public final static String USER_NAME_PASSWORD_FROM_USER = "select * from User where username = ? AND pass = ?";
}

