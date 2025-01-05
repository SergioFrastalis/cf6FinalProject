package gr.aueb.cf.cf6finalproject.service;

import gr.aueb.cf.cf6finalproject.entity.User;
import gr.aueb.cf.cf6finalproject.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}
