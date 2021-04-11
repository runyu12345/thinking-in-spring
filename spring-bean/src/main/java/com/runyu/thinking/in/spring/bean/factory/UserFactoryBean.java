package com.runyu.thinking.in.spring.bean.factory;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link com.runyu.thinking.in.spring.ioc.overview.domain.User}
 * Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 * @version 1.0 created by 2021.04.11 16:20:55 星期日
 * @auth 港岛妹夫
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
