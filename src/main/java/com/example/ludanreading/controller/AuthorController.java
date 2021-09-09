package com.example.ludanreading.controller;

import com.example.ludanreading.entity.AuthorIntroduction;
import com.example.ludanreading.service.IAuthorService;
import com.example.ludanreading.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController extends BaseController{
    @Autowired
    private IAuthorService authorService;

    @RequestMapping("avatar")
    public JsonResult<String> getAvatar(String authorname){
        String data = authorService.getAvatarByAuthorname(authorname);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("introduction")
    public JsonResult<String> getIntroduction(String authorname){
        String data = authorService.getIntroductionByAuthorname(authorname);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("all")
    public JsonResult<List<AuthorIntroduction>> getAuthor(){
        List<AuthorIntroduction> list = authorService.getAuthor();
        return new JsonResult<>(OK,list);
    }

    @RequestMapping("all_name")
    public JsonResult<List<String>> getAuthorname() {
        List<String> list = authorService.getAuthorname();
        return new JsonResult<>(OK,list);
    }
}
