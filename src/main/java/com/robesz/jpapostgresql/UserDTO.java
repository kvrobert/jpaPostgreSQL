package com.robesz.jpapostgresql;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    List<String> phoneNumbers;
    private String firstName;
    private String lastName;
}
