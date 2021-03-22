package com.runyu.thinking.in.spring.ioc.overview.domain;

import com.runyu.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 * @Author zhangrunyu
 * @Date 2021/3/22 10:44 下午
 * @Version 1.0
 */
@Super
public class SuperUser extends User{

    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
