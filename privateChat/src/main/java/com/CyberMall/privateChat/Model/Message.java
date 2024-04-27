package com.CyberMall.privateChat.Model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = "text"),
        @JsonSubTypes.Type(value = ImageMessage.class, name = "image")
})

//  Message Interface
public interface Message {
    String getContent();
    String getType();
    Long getSenderId();
    Long getReceiverId();
    String getSenderName();
    String getReceiverName();
    Long getProductId();
}