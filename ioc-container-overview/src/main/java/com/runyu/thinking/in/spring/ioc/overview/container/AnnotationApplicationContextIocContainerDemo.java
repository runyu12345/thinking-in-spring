package com.runyu.thinking.in.spring.ioc.overview.container;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * applicationContext demo
 * {@link org.springframework.context.ApplicationContext}
 * @version 1.0 created by 2021.03.24 07:31:02 星期三
 * @auth 港岛妹夫
 */
public class AnnotationApplicationContextIocContainerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 作为配置类
        applicationContext.register(AnnotationApplicationContextIocContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User对象:" + users);
        }
    }

    /**
     * 注解方式定义一个User Bean
     * @return
     */
    @Bean
    public User user(){
        User user = new User();
        user.setId(2L);
        user.setName("runyu12345");
        return user;
    }
}
