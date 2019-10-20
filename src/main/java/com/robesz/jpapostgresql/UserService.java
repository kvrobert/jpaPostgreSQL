package com.robesz.jpapostgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDTO userDTO){

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumbers(userDTO.getPhoneNumbers());

        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers(){

        List<UserDTO> userDTOS = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setPhoneNumbers(user.getPhoneNumbers());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

}
