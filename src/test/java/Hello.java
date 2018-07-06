import static java.lang.Thread.currentThread;

public class Hello  implements Runnable {
    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(new Hello());

        System.out.println("main start ");
        t.start();
        /*main 函数的线程在调用了此方法后，会等待t线程执行完后才接着执行main线面的内容，
          可以指定等地啊的时间，比如1001表示等待1001毫秒后就执行。
        */
        t.join(3001);

        System.out.println("main stop ");

    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
//                sleep(1000);//睡眠5秒，循环是为了方便输出信息
                System.out.println("睡眠"+ currentThread().getName());
            }
            System.out.println(currentThread().getName() + "  finished");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}