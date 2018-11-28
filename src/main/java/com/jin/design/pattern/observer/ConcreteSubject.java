package com.jin.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 具体的被观察对象
 * @auth jhj
 * @date 18-2-10 上午11:34
 */
public class ConcreteSubject implements ISubject {

    List<IObserver> observers = new ArrayList<IObserver>();
    private String message;

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++) {
            IObserver oserver = observers.get(i);
            oserver.update(message);
        }
    }
    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
