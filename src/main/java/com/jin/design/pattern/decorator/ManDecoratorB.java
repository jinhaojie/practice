package com.jin.design.pattern.decorator;

/**
 * @description
 * @auth jhj
 * @date 18-2-10 上午11:05
 */
public class ManDecoratorB extends Decorator {
    @Override
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}
