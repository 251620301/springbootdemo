package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb123456", userRepository.findByNameOrEmail("bb", "bb").getNickName());
        userRepository.delete(userRepository.findByName("aa1"));
    }

    @Test
    public void testJpa() throws Exception {
        int i = 1,size = 1;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(i,size,sort);
        userRepository.findAll(pageable);

    }


}
