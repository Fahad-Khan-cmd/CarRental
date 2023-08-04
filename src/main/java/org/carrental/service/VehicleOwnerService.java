package org.carrental.service;

import org.carrental.dao.VehicleOwnerDao;
import org.carrental.domain.Customer;
import org.carrental.domain.VehicleOwner;

import java.util.List;

public class VehicleOwnerService {



    VehicleOwnerDao vehicleOwnerDao = new VehicleOwnerDao();
            private String[][] transformToJtable(List<VehicleOwner> vehicleOwnerList, int columnsize){
                String[][] data = new String[vehicleOwnerList.size()][columnsize];
                for (int i =0; i<vehicleOwnerList.size(); i++) {
                    data[i][0] = String.valueOf(vehicleOwnerList.get(i).getId());
                    data[i][1] = vehicleOwnerList.get(i).getV_name();
                    data[i][2] = vehicleOwnerList.get(i).getCnic();
                    data[i][3] = vehicleOwnerList.get(i).getPhoneNumber();
                    data[i][4] = vehicleOwnerList.get(i).getAddress();
                    data[i][5] = String.valueOf(vehicleOwnerList.get(i).getCommission());
                }
                System.out.println(data);
                return data;
            }
            public String[][] getAllVehicleOwner(){
                List<VehicleOwner> vehicleOwnerList = vehicleOwnerDao.getAll();
                return transformToJtable(vehicleOwnerList,6);
            }

    public void add(String name, String phone, String cnic, String address, Float commision) {
        VehicleOwner vehicleOwner = VehicleOwner.builder()
                .v_name(name)
                .phoneNumber(phone)
                .cnic(cnic)
                .address(address)
                .commission(Float.valueOf(commision))

                .build();


            vehicleOwnerDao.insert(vehicleOwner);



    }

    public void deleteVehicleOwner(String id){
        VehicleOwner vehicleOwner = VehicleOwner.builder()
                .id(Integer.valueOf(id))
                .build();


        vehicleOwnerDao.deleteById(Long.valueOf(Integer.valueOf(id)));
    }

//
//    public void edit(String updatedName, String updatedPhoneNumber, String updatedCnic, String updatedAddress, Float updatedCommision, Integer id) {
//                    VehicleOwner vehicleOwner = VehicleOwner.builder()
//                            .id(id)
//                            .v_name(updatedName)
//                            .phoneNumber(updatedPhoneNumber)
//                            .cnic(updatedCnic)
//                            .address(updatedAddress)
//                            .commission(updatedCommision)
//                            .build();
//                    vehicleOwnerDao.update(vehicleOwner);
//
//            }

    public void editVehicleOwner( Integer id , String name, String phone, String cnic, String address, Float commision) {
                VehicleOwner vehicleOwner = VehicleOwner.builder()
                       // .id(id)
                        .v_name(name)
                        .phoneNumber(phone)
                        .cnic(cnic)
                        .address(address)
                        .commission(commision)

                        .build();

                vehicleOwnerDao.update(vehicleOwner,id);
            }
}
