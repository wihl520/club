package com.gzqf.clubapi.service;

import com.gzqf.club.entity.NewsPush;

import java.util.List;

public interface PushService {
    List<NewsPush> getPush();
    NewsPush getPushId(int id);
}
