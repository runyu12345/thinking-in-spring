package com.runyu.thinking.in.spring.bean.factory;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;

/**
 * 工厂类
 *
 * @version 1.0 created by 2021.04.11 16:04:08 星期日
 * @auth 港岛妹夫
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
