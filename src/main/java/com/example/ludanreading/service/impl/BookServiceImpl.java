package com.example.ludanreading.service.impl;

import com.example.ludanreading.entity.Author;
import com.example.ludanreading.entity.Book;
import com.example.ludanreading.mapper.AuthorMapper;
import com.example.ludanreading.mapper.BookMapper;
import com.example.ludanreading.service.IBookService;
import com.example.ludanreading.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Value("${book.path}")
    private String bookDir;

    @Override
    public String getBookContent(String bookname) throws BookNotExist {
        // 检查库中是否有这本书的数据
        Book result = bookMapper.findByBookname(bookname);
        if(result == null){
            throw new BookNotExist("该书本不存在");
        }
        // 获取书本所存储的路径
        String path = bookMapper.getPathByBookname(bookname);
        if(path == null){
            throw new BookPathNotExist("该书本路径不存在");
        }
        String filePath = bookDir + path + ".txt";
        // 从文件读取内容并返回
        String content = "";
        try {
            content = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            throw new ContentReadException("读取文件内容时产生未知的异常");
        }
        return content;
    }

    @Override
    public List<Book> getBookByAuthorname(String authorname) {
        // 检查作者信息是否存在
        Author result = authorMapper.findByAuthorname(authorname);
        if(result == null){
            throw new AuthorNotFound("该作者信息不存在");
        }
        List<Book> list = bookMapper.findByAuthorname(authorname);
        return list;
    }

    @Override
    public Integer insertBook(Book book) {
        book.setCreatedTime(new Date());
        book.setModifiedTime(new Date());
        Integer rows = bookMapper.insert(book);
        if(rows != 1){
            throw new BookInsertException("插入书籍信息时产生未知的异常");
        }
        return rows;
    }

    @Override
    public Book findByBookname(String bookname) {
        Book book = bookMapper.findByBookname(bookname);
        return book;
    }

    @Override
    public List<Book> findByType(String type) {
        List<Book> list = bookMapper.findByType(type);
        for(Book book:list){
            book.setModifiedUser(null);
            book.setCreatedUser(null);
            book.setCreatedTime(null);
            book.setModifiedTime(null);
        }
        return list;
    }


}
