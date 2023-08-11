package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:beans.xml")
@Import({User.class, DBHelper.class}) //调用对应类的无参构造器 , 自动创建默认类名的组件
@Configuration(proxyBeanMethods=true) //使用配置类 代替xml配置文件
@EnableConfigurationProperties(Car.class)//1.开启Car的配置绑定  2.把这个Car组件 自动注册到容器
public class MyConfig {


    /** 外部无论对配置类中的这个组件注册方法调用多少遍,获取的都是之前注册容器的单实例对象
     *
     * @return
     */
    //@ConditionalOnBean(name = "tom")//有名字为tom的组件时,才会将该方法返回的组件注册到容器
    @ConditionalOnMissingBean(name = "tom")//没有名字为tom的组件时,才会将该方法返回的组件注册到容器
    @Bean // 默认使用 方法名作为id , 返回类型为组件类型 ,返回值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //User组件依赖Pet组件
        zhangsan.setPet(tomcatPet());//将 tom宠物 装配到 User01的属性pet里
        return zhangsan;
    }

    //@Bean("tom")//自定义id
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
