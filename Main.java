public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        //calculating
        noThreads();
        withThreads();
    }

    public static void noThreads(){
        float[] arr = createArray();
        fillArray(arr);
        long a = System.currentTimeMillis();//start
        System.out.println("No Threads. Start " + a);
        calculate(arr);
        System.out.println(new StringBuilder("No Threads. End ").append(System.currentTimeMillis() - a)); //end
    }
    public static void withThreads(){
        float[] arr = createArray();
        fillArray(arr);
        long a = System.currentTimeMillis();//start
        System.out.println(new StringBuilder("Threads. Start ").append(a));
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println(new StringBuilder("Threads. End of separation ").append(System.currentTimeMillis() - a)); //end of separation
        Thread ct1 = new Thread(new CalculateThread(a1));
        Thread ct2 = new Thread(new CalculateThread(a2));
        ct1.start();
        ct2.start();
        try {
            ct1.join();
            ct2.join();
        }
        catch (InterruptedException e){
            System.out.println("Join failed with error" + e.toString());
        }
        System.out.println(new StringBuilder("Threads. End of calculation ").append(System.currentTimeMillis() - a)); //end of calculation
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(new StringBuilder("Threads. End of array merge ").append(System.currentTimeMillis() - a)); //end of merge

    }
    public static void calculate(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    public static float[] createArray(){

        float[] arr = new float[size];
        return arr;
    }
    public static void fillArray(float[] arr){
        Integer value = new Integer(1);
        float f = value.floatValue();
        for (int i = 0; i < size; i++) {
            arr[i] = f;
        }
    }

}
