package com.CyberMall.privateChat.Service;

import com.CyberMall.privateChat.Model.Message;

import java.util.List;

public interface MessageService {

    Message createMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                          String message, String messageType);
    List<Message> getAllMessages();
    List<Message> getMessagesBySenderAndReceiver(Long senderId, Long receiverId);
    List<Message> getMessagesByProductId(Long productId);
}
