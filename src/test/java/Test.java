import com.jin.design.pattern.decorator.Man;
import com.jin.design.pattern.decorator.ManDecoratorA;
import com.jin.design.pattern.decorator.ManDecoratorB;
import com.jin.design.pattern.observer.ConcreteObserver;
import com.jin.design.pattern.observer.ConcreteSubject;
import com.jin.design.pattern.observer.IObserver;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @description
 * @auth jhj
 * @date 18-2-10 上午11:06
 */

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("end");
                return;
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("hello mythread");
    }
}



public class Test {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    public static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public static void main(String[] args) {

//        System.out.println(COUNT_BITS);
//
//        System.out.println(1 << COUNT_BITS);
//        System.out.println(CAPACITY);
//        System.out.println(~CAPACITY);
//        System.out.println(Math.pow(2.0, 29));

        BigDecimal test = new BigDecimal("2.1200");
        System.out.println(test.toString());
        System.out.println(test.stripTrailingZeros());

    }

    private static void testDecorator() {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();

        md1.setPerson(man);
        md2.setPerson(md1);
        md2.eat();
    }

    private static void testObserver() {
        ConcreteSubject subject = new ConcreteSubject();

        IObserver userZhang = new ConcreteObserver("ZhangSan");
        IObserver userLi = new ConcreteObserver("userLi");
        IObserver userWang = new ConcreteObserver("userWang");

        subject.addObserver(userZhang);
        subject.addObserver(userLi);
        subject.addObserver(userWang);
        subject.setInfomation("java是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        subject.removeObserver(userZhang);
        subject.setInfomation("JAVA是世界上最好用的语言！");
    }

    /**
     * ThreadLocal test
     */
    @org.junit.Test
    public void test() {
        User user = new User();
        user.setName("jinhaojie");
        threadLocal.set(user);

        User rst = threadLocal.get();
        System.out.println(rst.getName());

        new Thread(){
            @Override
            public void run() {
                User user = new User();
                user.setName("zhangsan");
                threadLocal.set(user);
                User rst = threadLocal.get();
                System.out.println(rst.getName());
            }
        }.start();
    }

    @org.junit.Test
    public void testJoin() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread1");
                try {
                    sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread");


    }

    @org.junit.Test
    public void testReference() {

        final ReferenceQueue queue = new ReferenceQueue();


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }


                System.out.println("start");
                User user = new User();
                user.setName("jh1");
                SoftReference<User> softReference = new SoftReference<User>(user, queue);
                user = null;
                System.gc();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();



        while (true) {
            while (queue.poll() != null) {
                System.out.println("queue is not null");
            }
        }
    }


    public static final ThreadLocal<String> firstThreadLcoal = new ThreadLocal<>();
    public static final ThreadLocal<String> secondThreadLcoal = new ThreadLocal<>();

    @org.junit.Test
    public void testThreadLocal() {

        firstThreadLcoal.get();
        secondThreadLcoal.get();

        firstThreadLcoal.set("first");
        secondThreadLcoal.set("second");


    }



}


class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {

        /**需要考虑空指针的地方*/

        // 1.给基本类型赋值包装类型
        Integer b = null;
        int a = b;

        // 2.包装类型类型的算术比较和取值 >,==,<,对于==和!=推荐使用 Objects.equals避免控制正
        Integer c = null, d = null;
        Objects.equals(c, d);


    }
}