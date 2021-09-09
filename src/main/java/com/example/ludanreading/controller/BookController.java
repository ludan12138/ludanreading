package com.example.ludanreading.controller;

import com.example.ludanreading.controller.ex.*;
import com.example.ludanreading.entity.Book;
import com.example.ludanreading.service.IBookService;
import com.example.ludanreading.service.ex.BookInsertException;
import com.example.ludanreading.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController extends BaseController{
    @Autowired
    private IBookService bookService;

    @RequestMapping("content")
    public JsonResult<String> getContent(String bookname){
        String content = bookService.getBookContent(bookname);
        return new JsonResult<>(OK,content);
    }

    @RequestMapping("authorname")
    public JsonResult<List<Book>> getBook(String authorname){
        List<Book> list = bookService.getBookByAuthorname(authorname);
        return new JsonResult<>(OK,list);
    }

    public static final int TXT_SIZE = 10*1024*1024;
    public static final String FILE_TYPE = "text/plain";
    @Value("${book.path}")
    private String bookSavePath;
    @RequestMapping("upload")
    public JsonResult<Void> uploadBook(@RequestParam("file") MultipartFile file,@RequestParam("authorname") String authorname,@RequestParam("uploadName") String uploadName){
        // 判断文件是否为空
        if(file.isEmpty()){
            throw new FileEmptyException("上传的文件不能为空");
        }
        // 判断文件大小是否合适
        if(file.getSize() > TXT_SIZE){
            throw new FileSizeException("文件过大");
        }
        // 判断文件类型
        String type = file.getContentType();
        System.err.println(type);
        if(!FILE_TYPE.equals(type)){
            throw new FileTypeException("只可以上传txt文件");
        }
        // 存储到指定路径中
        String fileName = file.getOriginalFilename();
        int beginIndex = fileName.lastIndexOf(".");
        String bookname = fileName.substring(0,beginIndex);
        // 检查是否已经存在这本书
        Book result = bookService.findByBookname(bookname);
        if(result != null){
            throw new FileAlreadyExist("该书籍已存在");
        }
        String savePath = bookSavePath + fileName;
        File savedFile = new File(savePath);
        try{
            file.transferTo(savedFile);
        }catch (FileStateException e){
            throw new FileStateException("文件的状态出错");
        }catch (IOException e){
            throw new FileUploadIOException("文件上传出错");
        }
        Book book = new Book();
        book.setBookname(bookname);
        book.setAuthor(authorname);
        book.setPath(bookname);
        book.setCreatedUser(uploadName);
        book.setModifiedUser(uploadName);
        bookService.insertBook(book);
        return new JsonResult<>(OK);
    }

    @RequestMapping("type")
    public JsonResult<List<Book>> getBookByType(String type){
        List<Book> list = bookService.findByType(type);
        return new JsonResult<>(OK,list);
    }
}
