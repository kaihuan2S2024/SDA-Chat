package com.CyberMall.privateChat.Service;

import com.CyberMall.privateChat.Factory.TextMessageFactory;
import com.CyberMall.privateChat.Factory.ImageMessageFactory;
import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Factory.MessageFactory;
import com.CyberMall.privateChat.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


// Message Service Implementation
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private MessageFactory messageFactory;

    @Autowired
    private TextMessageFactory textMessageFactory;

    @Autowired
    private ImageMessageFactory imageMessageFactory;

    // Create Message
    @Override
    public Message createMessage(Long senderId, Long receiverId, Long productId,
                                 String senderName, String receiverName,
                                 String message, String messageType) {
        Message messageObject;
        if ("text".equalsIgnoreCase(messageType)) {
            messageObject = textMessageFactory.createMessage(senderId, receiverId, productId,
                                            senderName, receiverName, message, messageType);
        } else if ("image".equalsIgnoreCase(messageType)) {
            messageObject = imageMessageFactory.createMessage(senderId, receiverId, productId,
                                            senderName, receiverName, message, messageType);
        } else {
            throw new IllegalArgumentException("Unsupported message type: " + messageType);
        }
        return messageRepo.save(messageObject);
    }

    // Get All Messages
    @Override
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    // Get Messages by Sender and Receiver
    @Override
    public List<Message> getMessagesBySenderAndReceiver(Long senderId, Long receiverId) {

        // Getting all messages from sender to receiver and receiver to sender
        List<Message> messagesFromSenderToReceiver = messageRepo.findBySenderIdAndReceiverId(senderId, receiverId);
        List<Message> messagesFromReceiverToSender = messageRepo.findBySenderIdAndReceiverId(receiverId, senderId);

        List<Message> allMessages = new ArrayList<>();
        allMessages.addAll(messagesFromSenderToReceiver);
        allMessages.addAll(messagesFromReceiverToSender);

        return allMessages;
    }

    // Get Messages by Product Id
    @Override
    public List<Message> getMessagesByProductId(Long productId) {
        return messageRepo.findByProductId(productId);
    }
}