import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private CyclicBarrier barrier;
    private CountDownLatch countDownStart;
    private CountDownLatch countDownFinish;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier barrier,CountDownLatch countDownStart,CountDownLatch countDownFinish) {
        this.barrier = barrier;
        this.countDownStart = countDownStart;
        this.countDownFinish = countDownFinish;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            barrier.await();
            System.out.println(this.name + " готов");
            countDownStart.countDown();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            countDownFinish.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
