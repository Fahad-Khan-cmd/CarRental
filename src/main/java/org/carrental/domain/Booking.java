package org.carrental.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Booking {

    private Integer id;
    private Integer cid;
    private Integer vid;
    private Date booking_date;
    private Double price;
    private String booking_status;
//    private Date start_date;
//    private Date end_date;

    private Date complete_date;
    private Double commission;
    private String c_name;
    private String v_name;
    private Integer total_days;
    private Integer total_amount;

}
