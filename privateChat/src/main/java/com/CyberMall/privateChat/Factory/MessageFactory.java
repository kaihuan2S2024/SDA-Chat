package com.CyberMall.privateChat.Factory;
import com.CyberMall.privateChat.Model.Message;

public abstract class MessageFactory {
    public abstract Message createMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                                          String content, String messageType);
}
