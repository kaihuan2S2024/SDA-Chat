package com.CyberMall.privateChat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TextMessage implements Message {

    public static final String SEQUENCE_NAME = "message_sequence";

    @Id
    private String messageId;
    private Long senderId;
    private Long receiverId;
    private Long productId;
    private String senderName;
    private String receiverName;
    private String messageType;
    private String content;
    private Date timestamp;

    // Constructors
    public TextMessage(Long senderId, Long receiverId, Long productId, String senderName, String receiverName,
                       String content, String messageType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.productId = productId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.messageType = messageType;
        this.content = content;
        this.timestamp = new Date();
    }

    // Message interface methods
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getType() {
        return messageType;
    }
}
