package com.cyt.library.dao;

import com.cyt.library.bean.BackLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BackLogDao {
    Boolean addBackLog(BackLog object);
    Boolean delBackLog(int id);
}
