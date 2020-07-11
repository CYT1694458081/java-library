package com.cyt.library.controller;

import com.cyt.library.bean.BackLog;
import com.cyt.library.bean.Book;
import com.cyt.library.bean.BorrowLog;
import com.cyt.library.bean.User;
import com.cyt.library.domain.Res;
import com.cyt.library.service.BackLogService;
import com.cyt.library.service.BookService;
import com.cyt.library.service.BorrowLogService;
import com.cyt.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class BorrowAndBackController {
    @Autowired
    private BorrowLogService borrowLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private BackLogService backLogService;
    @Autowired
    private BookService bookService;
    //用户借书
    @RequestMapping("/public/borrowBook")
    public Res addBorrowLog(BorrowLog borrowLog){
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        borrowLog.setborrow_date(date);
        User user=userService.getUserById(borrowLog.getuser_id());
        Book book=bookService.getBookById(borrowLog.getbook_id());
        if(book.getNum()>=1){
            user.setborrow_num(user.getborrow_num()+1);
            book.setNum(book.getNum()-1);
            if(userService.upUser(user)){
                if(bookService.upBook(book)){
                    if(borrowLogService.addBorrowLog(borrowLog)){
                        return new Res(Res.SUCCESS,"借阅成功",null);
                    }
                    else return new Res(Res.FAILURE,"借阅失败，borrowLog添加失败",null);
                }
                else return new Res(Res.FAILURE,"借阅失败，book更新失败",null);
            }
            else return new Res(Res.FAILURE,"借阅失败,user更新失败",null);
        }
        else return new Res(Res.ERROR,"库存不足",null);

    }
    //用户还书
    @RequestMapping("/public/backBook")
    public Res backBook(BorrowLog borrowLog){
        LocalDateTime time=LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(time);
        BackLog backLog=new BackLog(borrowLog,date);
        User user=userService.getUserById(borrowLog.getuser_id());
        Book book=bookService.getBookById(borrowLog.getbook_id());
        user.setborrow_num(user.getborrow_num()-1);
        book.setNum(book.getNum()+1);
        if(borrowLogService.delBorrowLog(borrowLog.getborrow_id())){
            if(userService.upUser(user)){
                if(bookService.upBook(book)){
                    if(backLogService.addBackLog(backLog)){
                        return new Res(Res.SUCCESS,"归还成功",null);
                    }
                    else return new Res(Res.FAILURE,"归还失败,添加backLog失败",null);
                }
                else return new Res(Res.FAILURE,"归还失败,book更新失败",null);
            }
            else return new Res(Res.FAILURE,"归还失败,user更新失败",null);
        }
        else return new Res(Res.FAILURE,"归还失败,删除borrowLog失败",null);
    }
}
