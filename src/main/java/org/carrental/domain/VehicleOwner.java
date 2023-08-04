package org.carrental.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VehicleOwner {

    private Integer id;
    private String v_name;
    private String cnic;
    private String phoneNumber;
    private String address;
    private Float commission;
    private String vehicle_name;
}
