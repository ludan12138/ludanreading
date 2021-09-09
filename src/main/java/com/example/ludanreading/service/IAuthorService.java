package com.example.ludanreading.service;

import com.example.ludanreading.entity.Author;
import com.example.ludanreading.entity.AuthorIntroduction;

import java.util.List;

public interface IAuthorService {
    /**
     * 根据作者名获取其头像路径
     * @param authorname 作者名
     * @return 头像路径
     */
    String getAvatarByAuthorname(String authorname);

    /**
     * 根据作者名获取其介绍
     * @param authorname 作者名
     * @return 作者介绍
     */
    String getIntroductionByAuthorname(String authorname);

    /**
     * 查询所有作者信息
     * @return 作者信息列表
     */
    List<AuthorIntroduction> getAuthor();

    /**
     * 查询数据库中作者名字
     * @return 作者名字列表
     */
    List<String> getAuthorname();
}
