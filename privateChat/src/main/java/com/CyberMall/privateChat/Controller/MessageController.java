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

    /**
     * this function is used to create a message
     * @param message
     * @return
     */
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

        messagingTemplate.convertAndSend("/topic/" + message.getProductId(), savedMessage);

        return savedMessage;
    }

    /**
     * this function is used to get all messages
     * @return
     */
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    /**
     * this function is used to get messages of a specific product by its id
     * @param productId
     * @return
     */
    @GetMapping("/{productId}")
    public List<Message> getMessagesByProduct(
            @PathVariable Long productId
    ) {
        return messageService.getMessagesByProductId(productId);
    }

}
