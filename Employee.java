public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public void printInfo(){
        System.out.printf("Employee - [%s]," +
                " position - [%s]," +
                " email - [%s]," +
                " phone - [%s]," +
                " salary - [%s]," +
                " age - [%s]",
                name,position,email,phoneNumber,salary,age);
        System.out.println();
    }

}
