package com.jin.spring;

import com.jin.spring.bean.UserDO;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class TestBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition();


        beanDefinition.setBeanClass(UserDO.class);
        beanDefinition.setLazyInit(false);
        String id = element.getAttribute("id");


        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("name", element.getAttribute("name"));

        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

        return beanDefinition;
    }
}
