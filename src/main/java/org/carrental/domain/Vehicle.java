package org.carrental.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vehicle {

    private Integer id;
    private String vehicleName;
    private Integer vehicleYear;
    private Integer vehiclemodel;
    private String brand;
    private String color;
    private Integer oid;
    private String vehOwnerName;

}
