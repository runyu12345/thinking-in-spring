package com.runyu.thinking.in.spring.bean.definition;

import com.runyu.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @version 1.0 created by 2021.03.28 13:56:41 星期日
 * @auth 港岛妹夫
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件  objectFactory
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-definitions-context.xml");

        User gangdaomeifu = beanFactory.getBean("gangdao-meifu",User.class);
        User user = beanFactory.getBean("user",User.class);

        System.out.println(user == gangdaomeifu);
    }
}
