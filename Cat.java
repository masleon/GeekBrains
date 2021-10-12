public class Cat {
    private int maxJumpHeight;
    private int maxRunLength;
    private String name;
    public Cat(int maxJumpHeight,int maxRunLength, String name){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.name = name;
    }
    private void jump(){
        System.out.println("Cat is jumping.");
    }
    private void run(){
        System.out.println("Cat is running.");
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }
    @Override
    public String toString() {
        return "cat " + name;
    }
}
