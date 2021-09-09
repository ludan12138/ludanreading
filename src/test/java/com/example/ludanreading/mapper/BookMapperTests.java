package com.example.ludanreading.mapper;

import com.example.ludanreading.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void findByBookname(){
        Book book = bookMapper.findByBookname("test");
        System.out.println(book);
    }

    @Test
    public void getPathByBookname(){
        String path = bookMapper.getPathByBookname("test");
        System.out.println(path);
    }

    @Test
    public void findByAuthorname() {
        List<Book> list = bookMapper.findByAuthorname("test");
        for(Book book : list){
            System.out.println(book);
        }
    }
    @Test
    public void insert() {
        Book book = new Book();
        book.setBookname("但愿人长久");
        book.setAuthor("三毛");
        book.setPath("但愿人长久");
        book.setCreatedTime(new Date());
        book.setCreatedUser("卤蛋");
        book.setModifiedTime(new Date());
        book.setModifiedUser("卤蛋");
        bookMapper.insert(book);
    }

    @Test
    public void findByType() {
        List<Book> list = bookMapper.findByType("现当代文学");
        for(Book book : list){
            System.out.println(book);
        }
    }
}
