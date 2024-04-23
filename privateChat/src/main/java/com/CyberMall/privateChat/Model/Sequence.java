package com.CyberMall.privateChat.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// For auto generate primary key
@Document(collection = "sequences")
@Getter
@Setter
public class Sequence {

    @Id
    private String id;
    private int seq;

}
