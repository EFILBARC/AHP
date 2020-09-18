package SchoolManager;

import java.util.ArrayList;

public class SchoolSystem {

    public static void main(String[] args) {


        Teacher Adam = new Teacher(2326, "Adam",70000);
        Teacher Kris = new Teacher(0513, "Kris", 70000);

        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        teacherArrayList.add(Adam);
        teacherArrayList.add(Kris);


        Student Luca = new Student(0403,"Luca",5);
        Student Jamie = new Student(0000,"Jamie", 16);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(Luca);
        studentArrayList.add(Jamie);


        School PEARLS = new School(teacherArrayList, studentArrayList);
        System.out.println(Luca);

    }
}



