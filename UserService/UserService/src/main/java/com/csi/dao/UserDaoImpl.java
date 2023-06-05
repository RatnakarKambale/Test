package com.csi.dao;

import com.csi.model.User;
import com.csi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserDaoImpl {

    @Autowired
    UserRepo userRepoImpl;


    public User saveData(User user) {

        return userRepoImpl.save(user);
    }

    public Optional<User> getDataById(int userId) {

        return  userRepoImpl .findById(userId);
    }
}
