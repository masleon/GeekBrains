public class Lesson_003 {

    public static void main (String[] args){
        task01();
        task02();
        task03();
        task04();
        print1DArray(task05(4,6));
        task06();
        int[] array = {4,3,2,1,1,2,3,4};
        System.out.println(task07(array));
        task08(array,-1);
    }

    static void task01(){
        int[] array = {1,0,0,0,1,1,0,1,1,0};
        for (int i =0;i<array.length;i++) {
            if (array[i] == 1) array[i] = 0; else array[i] = 1;
        }
        print1DArray(array);
    }

    static void task02(){
        int[] array = new int[100];
        for (int i = 0;i<array.length;i++){
            array[i]=i+1;
        }

        print1DArray(array);
    }

    static void task03(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0;i<array.length;i++){
            if (array[i]<6) array[i]=array[i]*2;
        }
        print1DArray(array);
    }

    static void task04(){
        int[][] array = new int[7][7];
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j<array[i].length;j++){
                if (i==j) array[i][j]=1;
                if (i==array[j].length-j-1) array[i][j]=1;
            }
        }
        print2DArray(array);
    }

    static int[] task05(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    static void task06(){
        int[] array = {2,4,5,3,7,9,8,5,4,2};
        int maxNumber=Integer.MIN_VALUE;
        int minNumber=Integer.MAX_VALUE;
        for (int i = 0;i<array.length;i++){
            if (array[i]<minNumber) minNumber = array[i];
            if (array[i]>maxNumber) maxNumber = array[i];
        }
        System.out.println("Min " + minNumber);
        System.out.println("Max " + maxNumber);
    }

    static boolean task07(int[] array){
        boolean isEqualPlace= false;
        for (int i = 0 ;i<array.length;i++){
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0;j<=i;j++){
                leftSum = leftSum + array[j];
            }
            for (int j = i+1;j<array.length;j++){
                rightSum = rightSum + array[j];
            }
            if (leftSum==rightSum) isEqualPlace=true;
        }
        return isEqualPlace;
    }

    static void task08(int[] array,int n){
        if (n<0) for (int i = 0;i>n;i--) arrayStepBackward(array);
        else for (int i = 0;i<n;i++) arrayStepForward(array);
        print1DArray(array);
    }

    static void arrayStepBackward(int[] array){
        int buffer_value = array[0];
        for (int j=0;j<array.length-1;j++){
            array[j]=array[j+1];
        }
        array[array.length-1]=buffer_value;
    }
    static void arrayStepForward(int[] array){
        int buffer_value = array[array.length-1];
        for (int j=array.length-1;j>0;j--){
            array[j]=array[j-1];
        }
        array[0]=buffer_value;
    }

    static void print1DArray(int[] array){
        for (int value:array) System.out.print(value + " ");
        System.out.println();
    }
    static void print2DArray(int[][] array){
        for (int[] value1d:array){
            for (int value2d:value1d) {
                System.out.print(value2d + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
