package com.zhaomlb.club.bootsp.respository;

import com.zhaomlb.club.bootsp.entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository  extends JpaRepository<UserDto,Long> {

}
