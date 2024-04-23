package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.ImageMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImageMessageRepo extends MongoRepository<ImageMessage, String> {
    List<ImageMessage> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}