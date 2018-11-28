package com.jin.design.pattern.observer;

/**
 * @description 被观察的对象接口
 * @auth jhj
 * @date 18-2-10 上午11:30
 */
public interface ISubject {
    void addObserver(IObserver observer); //添加观察者
    void removeObserver(IObserver observer); //删除观察者
    void notifyObserver(); //通知所有观察者
}
