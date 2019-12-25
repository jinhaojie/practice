package com.jin.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TestNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new TestBeanDefinitionParser());
    }
}
