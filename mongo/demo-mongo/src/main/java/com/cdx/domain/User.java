package com.cdx.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "User")
@Data
public class User {
    // 内嵌属性
    @Data
    public static class Profile{
        private String nickname;
        private String gender;
    }

    @Id
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
    private Profile profile;
}
