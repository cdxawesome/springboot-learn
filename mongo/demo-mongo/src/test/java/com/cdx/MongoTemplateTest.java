package com.cdx;

import com.cdx.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testFindById() {
        User user = mongoTemplate.findById(2, User.class);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(100);
        user.setUsername("cdx");
        user.setPassword("12345");
        user.setCreateTime(new Date());
        User.Profile profile = new User.Profile();
        profile.setNickname("小德");
        profile.setGender("男");
        user.setProfile(profile);
        mongoTemplate.insert(user);
    }
}
