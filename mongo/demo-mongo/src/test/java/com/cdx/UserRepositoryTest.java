package com.cdx;

import com.cdx.domain.User;
import com.cdx.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("dylan");
        user.setId(7); // 这里先写死，后面再做自增id的设置
        user.setCreateTime(new Date());
        user.setPassword("123456");
        User.Profile profile = new User.Profile();
        profile.setNickname("nickDylan");
        profile.setGender("male");
        user.setProfile(profile);
        userRepository.insert(user);
    }

    @Test
    public void testUpdate() {
        Optional<User> userResult = userRepository.findById(2);
        Assert.assertTrue("用户一定要存在",userResult.isPresent());
        User user = userResult.get();
        user.setUsername("rico");
        userRepository.save(user);
    }

    @Test
    public void testDelete()
    {
        userRepository.deleteById(1);
    }

    @Test
    public void testSelectById()
    {
        Optional<User> userResult = userRepository.findById(2);
        System.out.println(userResult.isPresent());
    }

    @Test
    public void testSelectByIds()
    {
        Iterable<User> allById = userRepository.findAllById(Arrays.asList(2, 3, 4));
        allById.forEach(System.out::println);
    }
}
