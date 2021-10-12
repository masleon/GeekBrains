public class Wall {
    private int height;
    public Wall(int height){
        this.height = height;
    }
    public boolean isObstaclePassed(Object performer){
        if (performer instanceof Human){
            return (((Human) performer).getMaxJumpHeight()>height);
        }
        if (performer instanceof Cat){
            return (((Cat) performer).getMaxJumpHeight()>height);
        }
        if (performer instanceof Robot){
            return (((Robot) performer).getMaxJumpHeight()>height);
        }
        return false;
    }
}
