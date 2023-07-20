package org.carrental.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.BindingType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    private Integer id;
    private String username;

    private String password;
}
