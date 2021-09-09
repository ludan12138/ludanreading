package com.example.ludanreading.controller;

import com.example.ludanreading.controller.ex.FileAlreadyExist;
import com.example.ludanreading.controller.ex.FileUploadException;
import com.example.ludanreading.service.ex.*;
import com.example.ludanreading.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    /**
     * 统一处理异常信息
     * 操作成功：200状态码表示成功
     */
    public static final int OK = 200;

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>();
        if(e instanceof BookNotExist){
            result.setState(4000);
            result.setMessage("书本数据不存在");
        }else if(e instanceof BookPathNotExist){
            result.setState(4001);
            result.setMessage("书本路径不存在");
        }else if(e instanceof AuthorNotFound){
            result.setState(4002);
            result.setMessage("作者信息不存在");
        }else if(e instanceof AvatarNotFound){
            result.setState(4003);
            result.setMessage("作者头像数据不存在");
        }else if(e instanceof IntroductionNotFound){
            result.setState(4004);
            result.setMessage("用户介绍数据不存在");
        }else if(e instanceof FileAlreadyExist){
            result.setState(4005);
            result.setMessage("该书籍已存在");
        }
        return result;
    }
}
