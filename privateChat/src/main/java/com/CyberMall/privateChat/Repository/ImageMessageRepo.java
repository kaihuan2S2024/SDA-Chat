package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.ImageMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


// Image Message Repository
public interface ImageMessageRepo extends MongoRepository<ImageMessage, String> {
    List<ImageMessage> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}