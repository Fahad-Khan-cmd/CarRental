package org.carrental.service;

import org.carrental.dao.VehicleDao;
import org.carrental.dao.VehicleOwnerDao;
import org.carrental.domain.Vehicle;
import org.carrental.domain.VehicleOwner;

import java.util.List;

public class VehicleService {

    VehicleDao vehicleDao = new VehicleDao();
    VehicleOwnerDao vehicleOwnerDao = new VehicleOwnerDao();


    public String[][] getAllVehicle(){
        List<Vehicle> vehicleList = vehicleDao.getAll();
        return transformToJTable(vehicleList,7);

    }



    private String[][] transformToJTable(List<Vehicle> vehicleList, int columnSize){
        String[][] data = new String[vehicleList.size()][columnSize];
        for (int i =0; i<vehicleList.size(); i++) {
            data[i][0] = String.valueOf(vehicleList.get(i).getId());
            data[i][1] = vehicleList.get(i).getVehicleName();
            data[i][2] = vehicleList.get(i).getBrand();
            data[i][3] = String.valueOf(vehicleList.get(i).getVehicleYear());
            data[i][4] = vehicleList.get(i).getColor();
            data[i][5] = String.valueOf(vehicleList.get(i).getVehiclemodel());
            data[i][6] = String.valueOf(vehicleList.get(i).getVehOwnerName());
        }
        //System.out.println(data);
        return data;
    }


    public void add(String name, Integer year, Integer model, String bRand, String cOlor, String Oid) {
            Vehicle vehicle = Vehicle.builder()
                    .vehicleName(name)
                    .vehicleYear(year)
                    .vehiclemodel(model)
                    .brand(bRand)
                    .color(cOlor)
                    .oid(Integer.valueOf(Oid))
                    .build();
            vehicleDao.insert(vehicle);

    }
    public void updateVehicle(String id, String name, Integer year, String brand, Integer model, String color, Integer oid ){
        Vehicle vehicle = Vehicle.builder()
                .vehicleName(name)
                .vehicleYear(year)
                .brand(brand)
                .vehiclemodel(model)
                .color(color)
                .oid(Integer.valueOf(oid))

                .build();
        vehicleDao.update(vehicle, Integer.valueOf(id));
    }

    public void deleteVehicle(Integer id){
        Vehicle vehicle = Vehicle.builder()
                .id(id)
                .build();


        vehicleDao.deleteById(Long.valueOf(Integer.valueOf(id)));
    }

    public String[] getAllOwners() {
        List<VehicleOwner> ownerList = vehicleOwnerDao.getAll();
        String[] owners = new String[ownerList.size()];
        for (int i = 0; i < ownerList.size(); i++) {
            owners[i] = String.valueOf(ownerList.get(i).getId());
            owners[i] += ", " + ownerList.get(i).getV_name();
        }
        return owners;
    }

}
