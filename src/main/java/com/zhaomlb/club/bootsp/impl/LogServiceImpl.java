package com.zhaomlb.club.bootsp.impl;

import com.zhaomlb.club.bootsp.entity.LogDto;
import com.zhaomlb.club.bootsp.respository.LogRespository;
import com.zhaomlb.club.bootsp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRespository logRespository;
    @Override
    public LogDto insert(LogDto logDto) {
        return  logRespository.save(logDto);

    }
}
