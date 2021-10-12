public class Treadmill {
    private int length;
    public Treadmill(int length){
        this.length = length;
    }
    public boolean isObstaclePassed(Object performer){
        if (performer instanceof Human){
            return (((Human) performer).getMaxRunLength()>length);
        }
        if (performer instanceof Cat){
            return (((Cat) performer).getMaxRunLength()>length);
        }
        if (performer instanceof Robot){
            return (((Robot) performer).getMaxRunLength()>length);
        }
        return false;
    }

}
