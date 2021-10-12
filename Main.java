public class Main {
    public static void main(String[] args) {
        Object[] performers = new Object[] {
                new Human(10,12,"Konstantin"),
                new Cat(20,30,"Barsik"),
                new Cat(23,28,"Murzik"),
                new Robot(40,50,"C3piO")
        };
        Object[] obstacles = new Object[]{
                new Treadmill(7),
                new Wall(9),
                new Wall(29),
                new Treadmill(25),
                new Wall(39),
                new Treadmill(60)
        };

        for (Object performer:performers) {
            for (Object obstacle:obstacles) {
               if (obstacle instanceof Treadmill){
                   if (!((Treadmill) obstacle).isObstaclePassed(performer)){
                       break;
                   }
                   else System.out.println("Obstacle " + obstacle + " passed by " + performer);
               }
               if (obstacle instanceof Wall){
                   if (!((Wall) obstacle).isObstaclePassed(performer)){
                       break;
                   }
                   else System.out.println("Obstacle " + obstacle + " passed by " + performer);
               }
            }
        }
    }


}
