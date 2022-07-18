package com.midas.auth.service;
import com.midas.auth.Repository.UserRepository;
import com.midas.auth.dto.UserAddRequestRest;
import com.midas.auth.dto.UserUpdatePasswordRequestRest;
import com.midas.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //List<User> users = new ArrayList<>();

    public User adduser(UserAddRequestRest request) {
        User user = User.builder()
                .name(request.getName())
                .mobileNumber(request.getMobileNumber())
                .email(request.getEmail())
                .password(request.getPassword())
                .createdAt(new Date(System.currentTimeMillis()))
                .isActive(true)
                .build();

        return userRepository.save(user);
    }

    public List<User> getAllUser()
    {
        return userRepository.findAllBy();
    }

    public User getAllUserByMobileNumber(String mobileNumber)
    {
        return userRepository.findByMobileNumber(mobileNumber);
    }

    public User getAllUserByName(String name)
    {
        return userRepository.findByName(name);
    }

    public User updatePassword(User user, UserUpdatePasswordRequestRest request) {
        if(user.getPassword().equals(request.getOldPassword()))
        {
            user.setPassword(request.getNewPassword());
        }
        return userRepository.save(user);
    }

    public User deleteUser(User user) {

        user.setIsActive(false);
        return userRepository.save(user);
    }
}
