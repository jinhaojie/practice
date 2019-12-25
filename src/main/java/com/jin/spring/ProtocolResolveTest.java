package com.jin.spring;

import com.jin.spring.bean.UserDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ProtocolResolveTest {


    public static void main(String[] args) {

        String[] configLocation = {"spring_service.xml", "spring_custom_tag.xml"};

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(configLocation, false);

        // 增加自定义resource处理器，spring4.3 提供
        classPathXmlApplicationContext.addProtocolResolver(new CustomResourceLoader());

        classPathXmlApplicationContext.refresh();

        UserDO userDO = (UserDO) classPathXmlApplicationContext.getBean("user1");

//
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.setResourceLoader(classPathXmlApplicationContext);
//
//        reader.lo();


//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
//        classPathXmlApplicationContext.addProtocolResolver(new CustomResourceLoader());
//        classPathXmlApplicationContext.setConfigLocation("spring_service.xml");
//
//
//        classPathXmlApplicationContext.
//        classPathXmlApplicationContext.getBean("user");
//
        int a =1;

    }



}

class CustomResourceLoader implements ProtocolResolver{

    @Override
    public Resource resolve(String location, ResourceLoader resourceLoader) {
        return null;
    }
}