public class Dog extends Animal{
    public static int dogsCounter;
    public Dog() {
        super(500, 10);
        dogsCounter++;
    }

    @Override
    void run(int distance) {
        if (distance<=super.getMaxRunDistance())
        System.out.println("Dog have been run " + distance);
    }

    @Override
    void swim(int distance) {
        if (distance<=super.getMaxSwimDistance())
            System.out.println("Dog have been swim " + distance);
    }
}
