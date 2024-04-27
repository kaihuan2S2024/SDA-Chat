package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * This repo is used during development to test the user service
 * All User controller, class, and repo are not used for the project
 */
public interface UserRepo extends MongoRepository<User,Integer> {

    List<User> findAll();
    User findByUserId(Integer userId);
    User findByUsername(String username);
    User findByAccountId(String accountId);

}
