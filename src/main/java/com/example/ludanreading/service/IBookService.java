package com.example.ludanreading.service;

import com.example.ludanreading.entity.Book;
import com.example.ludanreading.mapper.BookMapper;

import java.util.List;

public interface IBookService {
    /**
     * 根据书名获取书本内容
     * @param bookname 书名
     * @return 书本内容
     */
    public String getBookContent(String bookname);

    /**
     * 通过作者名获取其作品
     * @param authorname 作者名
     * @return 书籍列表
     */
    public List<Book> getBookByAuthorname(String authorname);

    /**
     * 插入一条书籍信息
     * @param book 书籍信息
     * @return 返回受影响的行数
     */
    public Integer insertBook(Book book);

    /**
     * 根据书名查询书籍信息
     * @param bookname 书名
     * @return 书籍信息
     */
    public Book findByBookname(String bookname);

    /**
     * 根据书本类型查询书籍
     * @param type 书本类型
     * @return 书籍列表
     */
    public List<Book> findByType(String type);
}
