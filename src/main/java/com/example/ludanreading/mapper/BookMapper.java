package com.example.ludanreading.mapper;

import com.example.ludanreading.entity.Book;

import java.util.List;

public interface BookMapper {

    /**
     * 根据书名来查询书本信息
     * @param bookname 书名
     * @return 成功返回书本数据，否则返回null
     */
    String getPathByBookname(String bookname);

    /**
     * 根据书名查询书本数据
     * @param bookname 书名
     * @return 书本数据
     */
    Book findByBookname(String bookname);

    /**
     * 根据作者名查找其作品
     * @param author 作者名
     * @return 书籍的列表
     */
    List<Book> findByAuthorname(String author);

    /**
     * 插入一条书籍数据
     * @param book 书本信息
     * @return
     */
    Integer insert(Book book);

    /**
     * 根据书本的类型查询书籍
     * @param type 书本类型
     * @return 书籍列表
     */
    List<Book> findByType(String type);
}
