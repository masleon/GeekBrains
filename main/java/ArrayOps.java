import java.util.ArrayList;

public class ArrayOps {
    public static int[] doLastFourArrayReturn(int[] data){

        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < data.length; i++) {
            if (data[i]==4){
                list.clear();
            }
            else list.add(data[i]);
        }
        int[] returnData = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnData[i] = list.get(i);
        }
        return returnData;
    }
    public static boolean isFoursOrOneInIntArray(int[] data){
        for (int i = 0; i < data.length; i++) {
            if (data[i]==1||data[i]==4) return true;
        }
        return false;
    }
}
