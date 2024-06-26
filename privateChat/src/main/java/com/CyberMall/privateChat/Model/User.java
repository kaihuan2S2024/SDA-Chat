package com.CyberMall.privateChat.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * This user class is used during development to test the user service
 * All User controller, class, and repo are not used for the project
 */
@Document
@Data
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private Integer userId;
    private String username;
    private String password;
    // account id cannot be changed once set
    private String accountId;
    private String role;

}
