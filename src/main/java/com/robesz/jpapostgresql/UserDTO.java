package com.robesz.jpapostgresql;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    List<String> phoneNumbers = new ArrayList<>();
}
