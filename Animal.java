public abstract class Animal {
    private final int maxRunDistance;
    private final int maxSwimDistance;
    public static int animalsCounter;

    abstract void run(int distance);

    abstract void swim(int distance);

    public Animal(int maxRunDistance, int maxSwimDistance) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalsCounter++;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }
}
