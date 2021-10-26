public class CalculateThread implements Runnable{
    float[] arr;

    public CalculateThread(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        Main.calculate(arr);
    }
}
