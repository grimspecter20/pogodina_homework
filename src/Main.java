import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("Анна", 1, 2, List.of(5, 4, 4, 5, 5)));
        students.add(new Student("Иван", 2, 3, List.of(3, 2, 3, 2, 4)));
        students.add(new Student("Мария", 1, 1, List.of(2, 4, 4, 5, 3)));

        Student.deleteStudent(students);
        Student.transferCourse(students);
        Student.printStudents(students,3);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "111-11-11");
        phonebook.add("Петров", "222-22-22");
        phonebook.add("Сидоров", "333-33-33");
        phonebook.add("Иванов", "444-44-44");
        phonebook.add("Кузнецов", "555-55-55");
        phonebook.add("Сидоров", "666-66-66");
        phonebook.get("Иванов");
    }
}