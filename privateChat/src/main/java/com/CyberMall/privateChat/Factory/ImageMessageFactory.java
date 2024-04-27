package com.CyberMall.privateChat.Factory;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Model.ImageMessage;
import org.springframework.stereotype.Component;

// Concrete Image Message Factory
@Component
public class ImageMessageFactory extends MessageFactory {
    @Override
    public Message createMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                                 String content, String messageType) {
        return new ImageMessage(senderId, receiverId, productId, senderName, receiverName, content, messageType);
    }
}

