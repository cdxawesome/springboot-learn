package com.cdx.repository;

import com.cdx.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository2 extends MongoRepository<User,Integer> {


    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据用户名进行模糊查询
     * @param username
     * @param pageable
     * @return
     */
    Page<User> findByUsernameLike(String username, Pageable pageable);
}
