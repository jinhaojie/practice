package com.jin.design.pattern.decorator;

/**
 * @description 抽象装饰者
 * @auth jhj
 * @date 18-2-10 上午11:02
 */
public abstract class Decorator implements Person{

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        person.eat();
    }
}
