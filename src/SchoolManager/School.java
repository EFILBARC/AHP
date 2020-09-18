package SchoolManager;

import java.util.ArrayList;

public class School {

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private static int totalIncome;
    private static int totalExpenses;

/*        School(int teachers, int students, double income, double expenses){
            int adults = teachers;
            int kids = students;
            double in = income;
            double out = expenses;
        }*/

    public School(ArrayList<Teacher> teachers, ArrayList<Student> students){
        this.teachers = teachers;
        this.students = students;
        totalIncome = 0;
        totalExpenses = 0;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public static void addIncome(int income) {
        totalIncome += income;
    }

    public static void addExpenses(int expense) {
        totalExpenses -= expense;
    }
}
