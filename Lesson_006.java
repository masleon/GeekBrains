public class Lesson_006 {

    public static void main(String[] args){

        Animal[] animals = {new Cat(),
        new Cat(), new Dog(),new Dog(), new Dog()};
        System.out.println("Animals total:" + Animal.animalsCounter);
        System.out.println("Dogs total:" + Dog.dogsCounter);
        System.out.println("Cats total:" + Cat.catsCounter);

        animals[1].swim(10);
        animals[3].run(30);
    }

}
