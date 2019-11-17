package com.gzqf.club.service.impl;

import com.gzqf.club.dao.MemDeadlineDao;
import com.gzqf.club.entity.MemberDeadline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl {
    private int status=0;
    @Autowired
    private MemDeadlineDao dao;
    public void MyTask(){
        if(status==1){
            return;
        }
        try {
            status = 1;
            List<MemberDeadline> list = dao.getDateList();
            for (MemberDeadline memDeadline : list) {
                Integer totalDay = (memDeadline.getTotalDay() - 1) > 0 ? (memDeadline.getTotalDay() - 1) : 0;
                if (totalDay != 0) {
                    memDeadline.setTotalDay(totalDay);
                    dao.updateDate(memDeadline);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            status=0;
        }
    }
}
