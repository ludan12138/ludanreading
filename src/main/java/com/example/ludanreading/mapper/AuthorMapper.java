package com.example.ludanreading.mapper;

import com.example.ludanreading.entity.Author;

import java.util.List;

public interface AuthorMapper {
    /**
     * 根据作者名查询作者信息
     * @param authorname 作者名
     * @return 作者信息
     */
    Author findByAuthorname(String authorname);

    /**
     * 根据作者名获取其头像路径
     * @param authorname 作者名
     * @return 返回头像路径
     */
    String getAvatarByAuthorname(String authorname);

    /**
     * 根据作者名获取其介绍路径
     * @param authorname 作者名
     * @return 介绍所在路径
     */
    String getIntroductionByAuthorname(String authorname);

    /**
     * 查询所有作者信息
     * @return 返回作者信息列表
     */
    List<Author> getAuthor();

    /**
     * 获取数据库中存储的作者名字
     * @return 返回作者名字列表
     */
    List<String> getAuthorname();
}
