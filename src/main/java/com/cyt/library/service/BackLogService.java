package com.cyt.library.service;

import com.cyt.library.bean.BackLog;
import com.cyt.library.dao.BackLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackLogService {
    @Autowired
    private BackLogDao backLogDao;
    public Boolean addBackLog(BackLog object){return backLogDao.addBackLog(object);}
    public Boolean delBackLog(int id){return backLogDao.delBackLog(id);}
}
