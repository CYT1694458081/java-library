package com.cyt.library.dao;

import com.cyt.library.bean.LogList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogListDao {
    List<LogList> getAllBorrowList();
    List<LogList> getAllBackList();
    List<LogList> getBorrowListByName(String name);
    List<LogList> getBackListByName(String name);
    List<LogList> searchUserBorrowListByBook(@Param("user") String user,@Param("book") String book);
    List<LogList> searchUserBackListByBook(@Param("user") String user,@Param("book") String book);
    List<LogList> getBorrowListByKey(String key);
    List<LogList> getBackListByKey(String key);
}
