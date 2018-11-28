package com.jin.design.pattern.decorator;

/**
 * @description
 * @auth jhj
 * @date 18-2-10 上午11:04
 */
public class ManDecoratorA extends Decorator {
    @Override
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}
