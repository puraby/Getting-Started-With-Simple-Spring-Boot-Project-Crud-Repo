package com.midas.auth.controller;

import java.util.List;
import com.midas.auth.Repository.UserRepository;
import com.midas.auth.dto.UserAddRequestRest;
import com.midas.auth.dto.UserUpdatePasswordRequestRest;
import com.midas.auth.entity.User;
import com.midas.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/add")
    public ResponseEntity<String> addUser(
            @RequestBody UserAddRequestRest request) {
        try {
             userService.adduser(request);
             return new ResponseEntity<>("Operation Successful! \n Status : 200", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>> getAllUser()
    {
        try {
            return new ResponseEntity<>(userService.getAllUser() ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-mobileNumber")
    public ResponseEntity<User> getUserByMobileNumber(
            @RequestParam String mobileNumber
    )
    {
        try {
            return new ResponseEntity<>(userService.getAllUserByMobileNumber(mobileNumber) ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-name")
    public ResponseEntity<User> getUserByName(
            @RequestParam String name
    )
    {
        try {
            return new ResponseEntity<>(userService.getAllUserByName(name) ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/password-update")
    public ResponseEntity<String> updatePassword(
            @RequestBody UserUpdatePasswordRequestRest request
    )
    {
           User user = userRepository.findByEmail(request.getEmail());
            if(user != null) {
                userService.updatePassword(user, request);
                return new ResponseEntity<>("Operation Successful! \n Status : 200", HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("id") long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userService.deleteUser(user);
            return new ResponseEntity<>("Operation Successful! \n Status : 200", HttpStatus.OK);
        } else
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }

}
