package Lesson_007;

public class Cat {
    private boolean catIsFed;
    private String catName;
    public void eat(Plate plate, int foodSize){
        if (plate.descreaseFood(foodSize)) catIsFed = true; else catIsFed=false;
    }

    public Cat(String catName) {
        this.catName = catName;
    }
    @Override
    public String toString() {
        return catName + " is fed: " + catIsFed;
    }
}
