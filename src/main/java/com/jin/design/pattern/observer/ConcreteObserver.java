package com.jin.design.pattern.observer;

/**
 * @description 具体的观察者
 * @auth jhj
 * @date 18-2-10 上午11:44
 */
public class ConcreteObserver implements IObserver{
    private String name;
    private String message;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}
