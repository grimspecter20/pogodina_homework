import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Student {
    String name;
    int group;
    int course;
    List<Integer> grades;

    public Student(String name, int group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        double averageGrade = 0.0;
        if (!grades.isEmpty()) {
            long sum = 0;
            for (Integer grade : grades) {
                sum += grade;
            }
            averageGrade = (double) sum / grades.size();
        }
        return averageGrade;
    }

    public static void deleteStudent(HashSet<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    public static void transferCourse(HashSet<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course++;
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println("Студенты, обучающиеся на " + course + " курсе: " + student.name);
            }
        }
    }
}


