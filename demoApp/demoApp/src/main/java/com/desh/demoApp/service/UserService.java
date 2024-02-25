package com.desh.demoApp.service;

import com.desh.demoApp.dto.UserDTO;
import com.desh.demoApp.entity.User;
import com.desh.demoApp.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
         userRepo.save(modelMapper.map(userDTO, User.class));
         return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByUserId(String userId){
        User user = userRepo.getUserByUserId(userId);
        return modelMapper.map(user, UserDTO.class);
    }
}
