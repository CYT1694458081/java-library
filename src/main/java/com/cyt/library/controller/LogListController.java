package com.cyt.library.controller;

import com.cyt.library.bean.LogList;
import com.cyt.library.domain.Res;
import com.cyt.library.service.LogListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogListController {
    @Autowired
    private LogListService logListService;
    //获取所有借阅记录
    @RequestMapping("/public/getAllBorrowList")
    public Res getAllBorrowList(){
        List<LogList> list=logListService.getAllBorrowList();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //获取所有归还记录
    @RequestMapping("/public/getAllBackList")
    public Res getAllBackList(){
        List<LogList> list=logListService.getAllBackList();
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //查找对应用户的借阅记录
    @RequestMapping("/public/getBorrowListByName")
    public Res getBorrowListByName(@RequestParam("name") String name){
        List<LogList> list=logListService.getBorrowListByName(name);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //查找对应用户的归还记录
    @RequestMapping("/public/getBackListByName")
    public Res getBackListByName(@RequestParam("name") String name){
        List<LogList> list=logListService.getBackListByName(name);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名和用户名模糊查找借阅记录
    @RequestMapping("/public/getBorrowListByKey")
    public Res getBorrowListByKey(@RequestParam("key") String key){
        List<LogList> list=logListService.getBorrowListByKey(key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名和用户名模糊查找归还记录
    @RequestMapping("/public/getBackListByKey")
    public Res getBackListByKey(@RequestParam("key") String key){
        List<LogList> list=logListService.getBackListByKey(key);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名模糊查找对应用户的借阅记录
    @RequestMapping("/public/searchUserBorrowListByBook")
    public Res searchUserBorrowListByBook(@RequestParam("user") String user,@RequestParam("book") String book){
        List<LogList> list=logListService.searchUserBorrowListByBook(user, book);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
    //根据书名模糊查找对应用户的归还记录
    @RequestMapping("/public/searchUserBackListByBook")
    public Res searchUserBackListByBook(@RequestParam("user") String user,@RequestParam("book") String book){
        List<LogList> list=logListService.searchUserBackListByBook(user, book);
        return new Res(Res.SUCCESS,"查找成功",list);
    }
}
