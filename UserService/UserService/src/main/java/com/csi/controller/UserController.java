package com.csi.controller;

import com.csi.model.User;
import com.csi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/")
    public ResponseEntity<User> SaveData(@RequestBody User user){
        return  ResponseEntity.ok(userServiceImpl.saveData(user));
    }

    @GetMapping("/{userId}")
public ResponseEntity<Optional<User>> getDataById(@PathVariable int userId){
        return ResponseEntity.ok(userServiceImpl.getDataByID(userId));
    }

}
