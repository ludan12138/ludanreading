package com.example.ludanreading.service;

import com.example.ludanreading.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTests {
    @Autowired
    private IBookService bookService;

    @Test
    public void getContent(){
        String bookname = "test";
        String content = bookService.getBookContent(bookname);
        System.out.println(content);
    }

    @Test
    public void getBookByAuthorname() {
        List<Book> list = bookService.getBookByAuthorname("鲁迅");
        for(Book book : list){
            System.out.println(book);
        }
    }
}
