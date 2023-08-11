package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//这是一个SpringBoot应用
//@SpringBootApplication , 下面三个复合注解代表这个@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot")
public class MainApplication {


    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        /*//3、run.getBean()从容器中获取组件 , 默认单例
        Pet tom01=run.getBean("tom", Pet.class);
        Pet tom02=run.getBean("tom", Pet.class);
        System.out.println("组件："+(tom01==tom02));

        //4.MyConfig配置类的组件:com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$62034939@1da6ee17
        MyConfig bean=run.getBean(MyConfig.class);
        System.out.println("MyConfig配置类的组件:"+bean);

        //5.配置类的注解 默认就是@Configuration(proxyBeanMethods = true)
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //简单来说就是 保持组件单实例
        User user1=bean.user01();
        User user2=bean.user01();
        System.out.println("多次调用组件的注册方法 是否是单例对象: "+ (user1==user2));


        //6.依赖
        User user=run.getBean("user01",User.class);
        Pet pet=run.getBean("tom",Pet.class);
        System.out.println("用户的宠物 ,是否形成依赖"+ (user.getPet()==pet));*/


        //7. 使用@Conditional注解
        boolean tom=run.containsBean("tom");
        System.out.println("容器中是否有tom组件: "+tom);

        boolean user01=run.containsBean("user01");
        System.out.println("容器中是否有user01组件: "+user01);

        //8.导入配置文件到配置类 ,将bean 注册到容器里
        boolean haha=run.containsBean("haha");
        System.out.println("容器中是否有haha组件: "+haha);
        boolean hehe=run.containsBean("hehe");
        System.out.println("容器中是否有hehe组件: "+hehe);
    }

}
