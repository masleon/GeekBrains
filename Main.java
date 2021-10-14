public class Main {
    public static void main(String[] args) {
        try{
            int sum = processArray(new String[][]{
                    {"1", "1", "2", "3"},
                    {"1", "2", "2", "3"},
                    {"1", "1", "1", "4"},
                    {"5", "1", "2", "3"}
            });
            System.out.println("Sum " +sum);
        }
        catch (MyArrayDataException|MyArraySizeException e){
            System.out.println("Error during processing!");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

    public static int processArray(String[][] array){
        int sum = 0;
        if (array.length!=4) throw new MyArraySizeException("Wrong array size!");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length!=4) throw new MyArraySizeException("Wrong array size!");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Wrong data parsing in array cell " + i + " " + j, e);
                }
            }
        }
        return sum;

    }
}
