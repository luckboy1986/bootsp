package com.zhaomlb.club.bootsp.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Component
public class UserDto implements Serializable{



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String usrCode;
    private String usrNmae;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsrCode() {
        return usrCode;
    }

    public void setUsrCode(String usrCode) {
        this.usrCode = usrCode;
    }

    public String getUsrNmae() {
        return usrNmae;
    }

    public void setUsrNmae(String usrNmae) {
        this.usrNmae = usrNmae;
    }
}
