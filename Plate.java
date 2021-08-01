package Lesson_007;

public class Plate {
    private final int MAX_FOOD_SIZE = 30;
    private int foodSize;
    public boolean descreaseFood(int fedSize){
        if (fedSize<=foodSize) {
            foodSize = foodSize -fedSize;
            return true;
        } else return false;
    }
    public void increaseFood(int foodSize){
        foodSize = Math.min (foodSize,MAX_FOOD_SIZE);
    }

    public Plate(int foodSize) {
        this.foodSize = foodSize;
    }
    public Plate(){
        foodSize = MAX_FOOD_SIZE;
    }
}
