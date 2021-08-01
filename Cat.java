public class Cat extends Animal{
    public static int catsCounter;
    public Cat() {
        super(200, -1);
        catsCounter++;
    }

    @Override
    void run(int distance) {
        if (distance<=super.getMaxRunDistance())
            System.out.println("Cat have been run " + distance);
    }

    @Override
    void swim(int distance) {
       System.out.println("Cats can`t swim");
    }
}
