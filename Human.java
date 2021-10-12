public class Human {
    private int maxJumpHeight;
    private int maxRunLength;
    private String name;
    public Human(int maxJumpHeight,int maxRunLength,String name){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.name = name;
    }
    private void jump(){
        System.out.println("Human is jumping.");
    }
    private void run(){
        System.out.println("Human is running.");
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }

    @Override
    public String toString() {
        return "human " + name;
    }
}
