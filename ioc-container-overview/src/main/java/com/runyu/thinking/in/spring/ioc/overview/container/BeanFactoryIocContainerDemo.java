package com.runyu.thinking.in.spring.ioc.overview.container;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Ioc容器demo
 *
 * @version 1.0 created by 2021.03.24 07:16:55 星期三
 * @auth 港岛妹夫
 */
public class BeanFactoryIocContainerDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // XML 配置文件 classpath 路径
        String location = "classpath:/META-INF/dependency-look-up.xml";

        // 加载配置
       int beanDefinitionsCounts = reader.loadBeanDefinitions(location);
       System.out.println("Bean 加载的数量: " + beanDefinitionsCounts);

       lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User对象:" + users);
        }
    }

}
