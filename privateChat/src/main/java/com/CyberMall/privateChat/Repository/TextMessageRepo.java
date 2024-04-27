package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.TextMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


//  Text Message Repository
public interface TextMessageRepo extends MongoRepository<TextMessage, String> {
    List<TextMessage> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
