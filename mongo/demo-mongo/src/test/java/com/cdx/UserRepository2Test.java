package com.cdx;

import com.cdx.domain.User;
import com.cdx.repository.UserRepository2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepository2Test {
    @Autowired
    private UserRepository2 userRepository2;

    @Test
    public void testFindByName()
    {
        // 如果在数据库中Collection中有多个相同的记录，则会报错
        User rico = userRepository2.findByUsername("rico");
        System.out.println(rico);
    }

    @Test
    public void testFindByNameLike()
    {
        // 按照id降序
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        // 创建分页条件
        Pageable pageable= PageRequest.of(0,10,sort);
        // 执行分页操作
        Page<User> userPage = userRepository2.findByUsernameLike("dy", pageable);
        System.out.println(userPage.getTotalElements());
        System.out.println(userPage.getTotalPages());
    }
}
