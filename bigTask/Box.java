package bigTask;

import java.util.ArrayList;

public class Box<E> {
    private ArrayList<E> fruits;

    public Box() {
        fruits = new ArrayList();
    }
    public void addFruit(E fruit){
        fruits.add(fruit);
    }
    public float getWeight(){
        float weight = 0f;
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i) instanceof Apple) {
                weight = weight + 1.0f;
            } else if (fruits.get(i) instanceof Orange){
                weight = weight + 1.5f;
            }
        }
        return weight;
    }

    public boolean compare(Box<E> box){
        return box.getWeight() == this.getWeight();
    }
    public void extract(Box<E> box){
        for (int i = 0; i < fruits.size(); i++) {
            box.addFruit(fruits.get(i));
        }
        fruits.clear();
    }
}
