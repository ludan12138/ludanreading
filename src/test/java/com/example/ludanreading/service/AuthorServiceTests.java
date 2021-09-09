package com.example.ludanreading.service;

import com.example.ludanreading.entity.AuthorIntroduction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorServiceTests {
    @Autowired
    private IAuthorService authorService;

    @Test
    public void getAvatarByAuthorname(){
        String result = authorService.getAvatarByAuthorname("test");
        System.out.println(result);
    }

    @Test
    public void getIntruductionByAuthorname() {
        String result = authorService.getIntroductionByAuthorname("test");
        System.out.println(result);
    }

    @Test
    public void getAuthor() {
        List<AuthorIntroduction> list = authorService.getAuthor();
        for(AuthorIntroduction authorIntroduction : list){
            System.out.println(authorIntroduction);
        }
    }
}
