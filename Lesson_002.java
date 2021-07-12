public class Lesson_002 {

    public static void main(String[] args) {
        System.out.println(task_01(12,3));
        task_02(-3);
        task_03(52);
        task_04("Some text",3);
        System.out.println(task_05(2021));
    }

    static boolean task_01(int a,int b){
        if (a+b>10&&a+b<=20) return true; else return false;
    }
    static void task_02(int a){
        if (a<0) System.out.println("Число отрицательное"); else System.out.println("Число положительное");
    }
    static boolean task_03(int a){
        if (a<0) return true; else return false;
    }
    static void task_04(String text,int a){
        for (int i=0;i<a;i++){
            System.out.println(text);
        }
    }
    static boolean task_05(int year){
        if ((year%4==0&&year%100!=0)||year%400==0) return true;else return false;
    }
}
