package org.carrental.service;

import org.carrental.dao.BookingDao;
import org.carrental.domain.Booking;
import org.carrental.domain.Customer;
import org.carrental.domain.Vehicle;

import java.util.Date;
import java.util.List;

public class BookingService {
        BookingDao bookingDao = new BookingDao();
    private String[][] transformToJTable(List<Booking> bookings, int columnSize){
        String[][] data = new String[bookings.size()][columnSize];
        for (int i =0; i<bookings.size(); i++) {
            data[i][0] = String.valueOf(bookings.get(i).getId());
            data[i][1] = String.valueOf(bookings.get(i).getCid());
            data[i][2] = String.valueOf(bookings.get(i).getId());
            data[i][3] = String.valueOf(bookings.get(i).getPrice());
            data[i][4] = String.valueOf(bookings.get(i).getBooking_date());
            data[i][5] = String.valueOf(bookings.get(i).getComplete_date());
            data[i][6] = bookings.get(i).getV_name();
            data[i][7] = bookings.get(i).getC_name();
            data[i][8] = String.valueOf(bookings.get(i).getBooking_status());
//            data[i][9] = String.valueOf(bookings.get(i).getEnd_date());
        }
        System.out.println(data);
        return data;
    }
    public String[][] getAllBooking(){
        List<Booking> bookings = bookingDao.getAll();
        return transformToJTable(bookings,9);

    }
    public void book(Integer cid, Integer vid, Double price, Date bookingDate, String status){
        Booking booking = Booking.builder()
                .cid(cid)
                .vid(vid)
                .price(price)
                .booking_date(bookingDate)
                .booking_status(status)

                .build();
        bookingDao.insert(booking);
    }

    public String[] getVehicle() {
        List<Vehicle> vehicleList = bookingDao.getAllVehicles();
        String[] data = new String[vehicleList.size()];
        for (int i = 0; i < vehicleList.size(); i++) {
            data[i] = String.valueOf(vehicleList.get(i).getId());
            data[i] += "," + vehicleList.get(i).getVehicleName();
        }
        return data;
    }
    public String[] getVehicleActive() {
        List<Vehicle> vehicleList = bookingDao.getAllVehiclesActives();
        String[] data = new String[vehicleList.size()];
        for (int i = 0; i < vehicleList.size(); i++) {
            data[i] = String.valueOf(vehicleList.get(i).getId());
            data[i] += "," + vehicleList.get(i).getVehicleName();
        }
        return data;
    }
    public String[] getCustomerActive() {
        List<Customer> customerList = bookingDao.getAllCustomersActives();
        String[] data = new String[customerList.size()];
        for (int i = 0; i < customerList.size(); i++) {
            data[i] = String.valueOf(customerList.get(i).getId());
            data[i] += "," + customerList.get(i).getName();
        }
        return data;
    }
    public String[] getCustomer() {
        List<Customer> customerList = bookingDao.getAllCustomer();
        String[] data = new String[customerList.size()];
        for (int i = 0; i < customerList.size(); i++) {
            data[i] = String.valueOf(customerList.get(i).getId());
            data[i] += "," + customerList.get(i).getName();
        }
        return data;
    }


    public void add(Integer customerId, Integer vehicleId, Date bookingDate, Double amount) {
        Booking booking = Booking.builder()
                .cid(customerId)
                .vid(vehicleId)
                .booking_date(new java.sql.Date(bookingDate.getTime()))
                .price(amount)
//                .start_date(startId)
//                .end_date(endDate)
                .booking_status("active")
                .build();
        bookingDao.post(booking);
        System.out.println(vehicleId);
//        bookingDao.updateVehicleStatusAdd(vehicleId);
    }

    public void updateBooking(Integer id,Integer cusid, Integer vehid, Date completeDate, Double amount, String bookingStatus) {
        Booking booking = Booking.builder()
                .cid(cusid)
                .vid(vehid)
                .complete_date(completeDate)
                .price(amount)
                .booking_status(bookingStatus)
                .build();
            bookingDao.update(booking,id);
//        System.out.println(vehicleId);
//        bookingDao.updateVehicleStatusAdd(vehicleId);
    }

    public void deleteCustomer(String id){
        Customer customer = Customer.builder()
                .id(Long.valueOf(id))
                .build();


        bookingDao.deleteById(Long.valueOf(id));
    }
}
