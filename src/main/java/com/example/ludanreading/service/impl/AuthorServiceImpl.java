package com.example.ludanreading.service.impl;

import com.example.ludanreading.entity.Author;
import com.example.ludanreading.entity.AuthorIntroduction;
import com.example.ludanreading.mapper.AuthorMapper;
import com.example.ludanreading.service.IAuthorService;
import com.example.ludanreading.service.ex.AuthorNotFound;
import com.example.ludanreading.service.ex.AvatarNotFound;
import com.example.ludanreading.service.ex.IntroductionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class AuthorServiceImpl implements IAuthorService{
    @Autowired
    private AuthorMapper authorMapper;

    @Value("${author.introduction.path}")
    private String authorIntroductionDir;


    @Override
    public String getAvatarByAuthorname(String authorname) {
        // 查询该作者是否存在
        Author result = authorMapper.findByAuthorname(authorname);
        if(result==null){
            throw new AuthorNotFound("作者信息不存在");
        }
        String avatar = authorMapper.getAvatarByAuthorname(authorname);
        if(avatar == null){
            throw new AvatarNotFound("作者头像数据不存在");
        }
        return avatar;
    }

    @Override
    public String getIntroductionByAuthorname(String authorname) {
        // 查询该作者是否存在
        Author result = authorMapper.findByAuthorname(authorname);
        if(result==null){
            throw new AuthorNotFound("作者信息不存在");
        }
        // 查询作者的介绍是否存在
        String introductionPath = authorMapper.getIntroductionByAuthorname(authorname);
        if(introductionPath == null){
            throw new IntroductionNotFound("作者介绍没有找到");
        }
        // 根据介绍路径获取介绍内容
        String filePath = authorIntroductionDir + introductionPath;
        String introduction = "";
        try {
            introduction = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return introduction;
    }

    @Override
    public List<AuthorIntroduction> getAuthor() {
        List<Author> list = authorMapper.getAuthor();
        List<AuthorIntroduction> authorIntroductions = new ArrayList<AuthorIntroduction>();
        for(Author item : list){
            AuthorIntroduction author = new AuthorIntroduction();
            String name = item.getAuthorname();
            String introduction = getIntroductionByAuthorname(name);
            author.setName(name);
            author.setIntroduction(introduction);
            authorIntroductions.add(author);
        }
        return authorIntroductions;
    }

    @Override
    public List<String> getAuthorname() {
        List<String> list = authorMapper.getAuthorname();
        return list;
    }


}
