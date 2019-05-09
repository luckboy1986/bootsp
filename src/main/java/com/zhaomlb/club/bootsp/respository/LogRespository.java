package com.zhaomlb.club.bootsp.respository;

import com.zhaomlb.club.bootsp.entity.LogDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRespository extends JpaRepository<LogDto,Long> {

}
