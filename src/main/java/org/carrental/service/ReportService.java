package org.carrental.service;

import org.carrental.dao.ReportDao;
import org.carrental.domain.Booking;
import org.carrental.domain.VehicleOwner;

import java.sql.Date;
import java.util.List;

public class ReportService {
    ReportDao reportDao = new ReportDao();

    public String[][] getAllBookingForJTableFromStartDateTillEndDate(Date start, Date end)
    {
        List<Booking> bookingList = reportDao.getAllBookingsWithStartDateAndEndDate(start,end);
        return transformToJTableWithCustomerNameAndVehicleNameAndCommission(bookingList,8);
    }

    public String[][] getAllBookingForJTableFromStartDateTillEndDateCommsion(Date start, Date end)
    {
        List<Booking> bookingList = reportDao.getAllBookingsWithStartDateAndEndDate(start,end);
        return transformToJTableWithVehicleOwnerNameAndCommission(bookingList,8);
    }
    public String[][] commissionRep(Date startDate, Date endDate) {
        List<VehicleOwner> ownerList = reportDao.commissionReport(startDate, endDate);
        List<VehicleOwner> ownerListCommissionPercent = reportDao.commissionPercent(startDate, endDate);
        String[][] data = new String[ownerList.size()][4];
        for (int i = 0; i < ownerList.size(); i++) {
            data[i][0] = ownerList.get(i).getV_name();
            data[i][1] = String.valueOf(ownerList.get(i).getCommission());
            data[i][2] = ownerList.get(i).getVehicle_name();

        }
        for (int i = 0; i < ownerListCommissionPercent.size(); i++) {
            data[i][1] = ownerListCommissionPercent.get(i).getCommission()+ "%";
        }
        return data;
    }

    public String[][] transformToJTableWithVehicleOwnerNameAndCommission(List<Booking> vehicleOwners, int columnSize)
    {
        String[][] data = new String[vehicleOwners.size()][columnSize];

        for (int i = 0; i < vehicleOwners.size(); i++)
        {
            data[i][0] = String.valueOf(vehicleOwners.get(i).getV_name());
            data[i][1] = String.valueOf(vehicleOwners.get(i).getPrice());
            data[i][2] = String.valueOf(vehicleOwners.get(i).getCommission());
        }
        return data;
    }
    public String[][] transformToJTableWithCustomerNameAndVehicleNameAndCommission(List<Booking> bookingList, int columnSize)
    {
        String[][] data = new String[bookingList.size()][columnSize];

        for (int i = 0; i < bookingList.size(); i++)
        {
            data[i][0] = String.valueOf(bookingList.get(i).getId());
            data[i][1] = String.valueOf(bookingList.get(i).getC_name());
            data[i][2] = String.valueOf(bookingList.get(i).getV_name());
            data[i][3] = String.valueOf(bookingList.get(i).getBooking_date());
            data[i][4] = String.valueOf(bookingList.get(i).getComplete_date());
            data[i][5] = String.valueOf(bookingList.get(i).getPrice());
            data[i][6] = String.valueOf(bookingList.get(i).getCommission());
            data[i][7] = String.valueOf(bookingList.get(i).getBooking_status());
        }
        return data;
    }


    public Double getAllProfitForMonthlyReport(Date bookingDate, Date comDate){
        return reportDao.getTotalProfit(bookingDate, comDate);
    }

    public Double getAllPriceForMonthlyReport(Date bookingDate, Date comDate){
        return reportDao.getTotalPrice(bookingDate, comDate);
    }

    public Double getAllCommissionForMonthlyReport(Date start, Date end){
        return reportDao.getTotalCommission(start, end);
    }
}
