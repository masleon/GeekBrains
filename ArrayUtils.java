import java.util.ArrayList;

public class ArrayUtils {
    public <E> void switchElements(E[] array,int val1index, int val2index){
        E val1 = array[val1index];
        E val2 = array[val2index];
        array[val1index] = val1;
        array[val2index] = val2;
    }
    public <E> ArrayList<E> convertToArrayList(E[] array){
        ArrayList<E> arrayList = new ArrayList<E>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
    }
}
