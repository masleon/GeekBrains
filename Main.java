package Lesson_007;

public class Main {

    public static void main (String[] args){

        Plate plate = new Plate();
        Cat[] cats = {
                new Cat("Barsik"),
                new Cat("Pushok"),
                new Cat("Vasya"),
                new Cat("Marsik"),
                new Cat("Vasiliy")
        };
        for (int i = 0;i<=cats.length;i++){
            cats[i].eat(plate,10);
            System.out.println(cats[i]);
        }

    }
}
