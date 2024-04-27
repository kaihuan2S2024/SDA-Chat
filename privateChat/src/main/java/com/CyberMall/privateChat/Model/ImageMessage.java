package com.CyberMall.privateChat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.util.Date;


// Concrete Text Message
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ImageMessage implements Message {

    public static final String SEQUENCE_NAME = "message_sequence";

    @Id
    private String messageId;
    private Long senderId;
    private Long receiverId;
    private Long productId;
    private String senderName;
    private String receiverName;
    private String messageType;
    private String uri;
    private Date timestamp;

    public ImageMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                        String content, String messageType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.productId = productId;
        this.messageType = messageType;
        this.uri = content;
        this.timestamp = new Date();
    }



    @Override
    public String getContent() {
        return uri;
    }

    @Override
    public String getType() {
        return messageType;
    }
}
