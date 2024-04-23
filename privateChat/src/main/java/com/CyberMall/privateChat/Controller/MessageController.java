package com.CyberMall.privateChat.Controller;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping
    public Message createMessage(
            @RequestBody Message message) {
        Message savedMessage = messageService.createMessage(
                message.getSenderId(),
                message.getReceiverId(),
                message.getProductId(),
                message.getSenderName(),
                message.getReceiverName(),
                message.getContent(),
                message.getType()
        );

        // Send the message to the appropriate WebSocket topic
//        messagingTemplate.convertAndSendToUser(
//                message.getReceiverId().toString(),
//                "/queue/messages",
//                savedMessage);
        messagingTemplate.convertAndSend("/topic/" + message.getProductId(), savedMessage);

        return savedMessage;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{productId}")
    public List<Message> getMessagesByProduct(
            @PathVariable Long productId
    ) {
        return messageService.getMessagesByProductId(productId);
    }

}
