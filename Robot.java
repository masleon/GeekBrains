public class Robot {
    private int maxJumpHeight;
    private int maxRunLength;
    private String name;
    public Robot(int maxJumpHeight,int maxRunLength, String name){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.name = name;
    }
    private void jump(){
        System.out.println("Robot is jumping.");
    }
    private void run(){
        System.out.println("Robot is running.");
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }
    @Override
    public String toString() {
        return "robot " + name;
    }
}
