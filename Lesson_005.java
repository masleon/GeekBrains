public class Lesson_005 {

    public static void main(String[] args){
        Employee[] employees = {
                new Employee("Vasya","driver","v@mail.ru","900-11-1",100,30),
                new Employee("Petya","chef","p@mail.ru","900-11-6",110,45),
                new Employee("Lena","painter","l@mail.ru","900-12-3",90,27),
                new Employee("Masha","blogger","m@mail.ru","900-15-2",150,60),
                new Employee("Katya","mother","k@mail.ru","900-18-7",140,99)
        };

        for (int i = 0;i<employees.length;i++)  if (employees[i].getAge()>40) employees[i].printInfo();
    }
}
