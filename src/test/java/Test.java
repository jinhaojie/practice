import com.jin.design.pattern.decorator.Man;
import com.jin.design.pattern.decorator.ManDecoratorA;
import com.jin.design.pattern.decorator.ManDecoratorB;
import com.jin.design.pattern.observer.ConcreteObserver;
import com.jin.design.pattern.observer.ConcreteSubject;
import com.jin.design.pattern.observer.IObserver;

/**
 * @description
 * @auth jhj
 * @date 18-2-10 上午11:06
 */
public class Test {

    public static ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public static void main(String[] args) {
        testObserver();
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


}


class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}