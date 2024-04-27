package com.CyberMall.privateChat.Factory;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Model.TextMessage;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


// Concrete Text Message Factory
@Component
@Primary
public class TextMessageFactory extends MessageFactory {

    @Override
    public Message createMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                                 String content, String messageType) {
        return new TextMessage(senderId, receiverId, productId, senderName, receiverName, content, messageType);
    }
}
