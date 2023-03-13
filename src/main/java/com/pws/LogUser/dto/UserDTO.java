package com.pws.LogUser.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private long phoneNumber;
}