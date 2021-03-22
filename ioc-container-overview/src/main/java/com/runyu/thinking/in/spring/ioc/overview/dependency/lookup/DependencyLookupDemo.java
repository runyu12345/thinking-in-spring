package com.runyu.thinking.in.spring.ioc.overview.dependency.lookup;

import com.runyu.thinking.in.spring.ioc.overview.annotation.Super;
import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1. 通过名称查找
 * 2. 通过类型查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件  objectFactory
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-look-up.xml");
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupByAnnotationType(beanFactory);
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 用户:" + users);
        }
    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User对象:" + users);
        }
    }


    private static void lookupByType(BeanFactory beanFactory) {
       User user =  beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    /**
     * 实时查找
     * @param beanFactory
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    /**
     * 延时查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
       ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
       User user = objectFactory.getObject();
       System.out.println("延迟查找:" + user);
    }
}
