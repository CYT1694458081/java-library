package com.cyt.library.service;

import com.cyt.library.bean.LogList;
import com.cyt.library.dao.LogListDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogListService {
    @Autowired
    private LogListDao logListDao;
    public List<LogList> getAllBorrowList(){return logListDao.getAllBorrowList();}
    public List<LogList> getAllBackList(){return logListDao.getAllBackList();}
    public List<LogList> getBorrowListByName(String name){return logListDao.getBorrowListByName(name);}
    public List<LogList> getBackListByName(String name){return logListDao.getBackListByName(name);}
    public List<LogList> getBorrowListByKey(String key){return logListDao.getBorrowListByKey("%"+key+"%");}
    public List<LogList> getBackListByKey(String key){return logListDao.getBackListByKey("%"+key+"%");}
    public List<LogList> searchUserBorrowListByBook(String user,String book){return logListDao.searchUserBorrowListByBook(user, "%"+book+"%");}
    public List<LogList> searchUserBackListByBook(String user,String book){return logListDao.searchUserBackListByBook(user, "%"+book+"%");}
}
