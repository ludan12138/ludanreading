package com.example.ludanreading.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorMapperTests {
    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void getAvatarByAuthorname(){
        String result = authorMapper.getAvatarByAuthorname("test");
        System.out.println(result);
    }

    @Test
    public void getIntroductionByAuthorname() {
        String result = authorMapper.getIntroductionByAuthorname("test");
        System.out.println(result);
    }

    @Test
    public void getAuthorname() {
        List<String> list = authorMapper.getAuthorname();
        System.out.println(list);
    }
}
