package com.robesz.jpapostgresql;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDTO userDTO){

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers(){

        return userRepository.findAll().stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                    })
                .collect(Collectors.toList());
    }

}
