package com.cyt.library.controller;


import com.cyt.library.bean.*;
import com.cyt.library.domain.Res;
import com.cyt.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testBoot")
public class TestController {
    @Autowired
    UserService userService;

    //User测试
    @RequestMapping("/showAllUser")
    public List showU() {
        List<User> list = userService.getAllUser();
        return list;
    }

    @RequestMapping("/searchUser/{name}")
    public List searchU(@PathVariable("name") String name) {
        List<User> list = userService.searchUser(name);
        return list;
    }

    @RequestMapping("/addUser/{name}/{password}")
    public List addU(@PathVariable("name") String name, @PathVariable("password") String password) {
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        User user = new User(0, name, password, date, "管理员", 0);
        System.out.println(user);
        System.out.println(userService.addUser(user));
        List<User> list = userService.getAllUser();
        return list;
    }

    @RequestMapping("/upUser/{id}/{name}/{password}")
    public List upU(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("password") String password) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setPassword(password);
        System.out.println(user);
        System.out.println(userService.upUser(user));
        List<User> list = userService.getAllUser();
        return list;
    }

    @RequestMapping("/delUser/{id}")
    public List delU(@PathVariable("id") int id) {
        System.out.println(userService.delUser(id));
        List<User> list = userService.getAllUser();
        return list;
    }

    //Book测试
    @Autowired
    private BookService bookService;

    @RequestMapping("/showAllBook")
    public List showB() {
        List<Book> list = bookService.getAllBook();
        return list;
    }

    @RequestMapping("/searchBook/{name}")
    public List searchB(@PathVariable("name") String name) {
        List<Book> list = bookService.searchBook(name);
        return list;
    }

    @RequestMapping("/addBook/{name}/{content}/{type}/{num}")
    public List addB(
            @PathVariable("name") String name,
            @PathVariable("content") String content,
            @PathVariable("type") String type,
            @PathVariable("num") int num) {
        Book book = new Book(0, name, content, type, num);
        System.out.println(book);
        System.out.println(bookService.addBook(book));
        List<Book> list = bookService.getAllBook();
        return list;
    }

    @RequestMapping("/upBook/{id}/{name}/{content}/{type}/{num}")
    public List upB(@PathVariable("id") int id,
                    @PathVariable("name") String name,
                    @PathVariable("content") String content,
                    @PathVariable("type") String type,
                    @PathVariable("num") int num) {
        Book book = bookService.getBookById(id);
        book.setName(name);
        book.setContent(content);
        book.setType(type);
        book.setNum(num);
        System.out.println(bookService.upBook(book));
        List<Book> list = bookService.getAllBook();
        return list;
    }

    @RequestMapping("/delBook/{id}")
    public List delB(@PathVariable("id") int id) {
        System.out.println(bookService.delBook(id));
        List<Book> list = bookService.getAllBook();
        return list;
    }

    //loglist测试
    @Autowired
    private LogListService logListService;

    //获取所有借阅记录
    @RequestMapping("/getAllBorrowList")
    public List getAllBorrowList() {
        List<LogList> list = logListService.getAllBorrowList();
        return list;
    }

    //获取所有归还记录
    @RequestMapping("/getAllBackList")
    public List getAllBackList() {
        List<LogList> list = logListService.getAllBackList();
        return list;
    }

    //查找对应用户的借阅记录
    @RequestMapping("/getBorrowListByName/{name}")
    public List getBorrowListByName(@PathVariable("name") String name) {
        List<LogList> list = logListService.getBorrowListByName(name);
        return list;
    }

    //查找对应用户的归还记录
    @RequestMapping("/getBackListByName/{name}")
    public List getBackListByName(@PathVariable("name") String name) {
        List<LogList> list = logListService.getBackListByName(name);
        return list;
    }

    //根据书名和用户名模糊查找借阅记录
    @RequestMapping("/getBorrowListByKey/{key}")
    public List getBorrowListByKey(@PathVariable("key") String key) {
        List<LogList> list = logListService.getBorrowListByKey(key);
        return list;
    }

    //根据书名和用户名模糊查找归还记录
    @RequestMapping("/getBackListByKey/{key}")
    public List getBackListBykey(@PathVariable("key") String key) {
        List<LogList> list = logListService.getBackListByKey(key);
        return list;
    }

    //借书还书测试
    @Autowired
    private BackLogService backLogService;
    @Autowired
    private BorrowLogService borrowLogService;

    @RequestMapping("/borrowBook/{user}/{book}")
    public List addBorrowLog(@PathVariable("user") int userid,@PathVariable("book") int bookid) {
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        BorrowLog borrowLog=new BorrowLog(0,userid,bookid,date);
        User user = userService.getUserById(borrowLog.getuser_id());
        Book book = bookService.getBookById(borrowLog.getbook_id());
        user.setborrow_num(user.getborrow_num() + 1);
        book.setNum(book.getNum() - 1);
        System.out.println(userService.upUser(user));
        System.out.println(bookService.upBook(book));
        System.out.println(borrowLogService.addBorrowLog(borrowLog));
        List list=logListService.getAllBorrowList();
        return list;
    }

    //用户还书
    @RequestMapping("/backBook/{borrow}/{user}/{book}")
    public List backBook(@PathVariable("borrow") int borrowid,@PathVariable("user") int userid,@PathVariable("book") int bookid) {
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        BorrowLog borrowLog=new BorrowLog(borrowid,userid,bookid,date);
        BackLog backLog = new BackLog(borrowLog, date);
        User user = userService.getUserById(borrowLog.getuser_id());
        Book book = bookService.getBookById(borrowLog.getbook_id());
        user.setborrow_num(user.getborrow_num() - 1);
        book.setNum(book.getNum() + 1);
        System.out.println(userService.upUser(user));
        System.out.println(bookService.upBook(book));
        System.out.println(borrowLogService.delBorrowLog(borrowLog.getborrow_id()));
        System.out.println(backLogService.addBackLog(backLog));
        List list=logListService.getAllBackList();
        return list;
    }

}
