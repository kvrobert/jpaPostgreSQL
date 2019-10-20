package com.robesz.jpapostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private  UserService userService;
    private static final String VERSION = "0.0.1";

    @GetMapping( path = "/info")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, String > getInfo(){

        Map<String, String > info = new HashMap<>();
        info.put("time", new Date().toString());
        info.put("name", "JPA Test Application");
        info.put("version", VERSION);

        return info;
    }

    @PostMapping(path = "/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody UserDTO userDTO) {

        userService.createUser(userDTO);
    }

    @GetMapping( path = "/users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> getUsers(){

        return userService.getAllUsers();
    }
}
