package com.zhaomlb.club.bootsp.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "log")
@Component
public class LogDto {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String aopType;
    private String clsName;
    private String method;
    private String orgs;
    private String resPonse;
    @Column(name="CREATE_TIME",insertable=false, updatable=false)
    @Generated(GenerationTime.INSERT)
    private Timestamp createTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrgs() {
        return orgs;
    }

    public void setOrgs(String orgs) {
        this.orgs = orgs;
    }

    public String getResPonse() {
        return resPonse;
    }

    public void setResPonse(String resPonse) {
        this.resPonse = resPonse;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getAopType() {
        return aopType;
    }

    public void setAopType(String aopType) {
        this.aopType = aopType;
    }
}
