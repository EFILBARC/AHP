package SchoolManager;

/**
 * Keep track of student IDs, names, grades, tuitions, and payments.
 */

public class Student {

    private int id;
    private String name;
    private int grade;
    private int tuition;
    private int paid;


    /**
     * Create a new student object.
     * @param id
     * @param name
     * @param grade
     */
    public Student(int id, String name, int grade){
        this.paid = 0;
        this.tuition = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;

    }


    public void setGrade(int grade){
        this.grade = grade;
    }

    public void justPaid(int payment){
        paid+=payment;
        School.addIncome(payment);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getTuition() {
        return tuition;
    }

    public int getPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "The toString method is effective." +
                "Name: " +name +
                "Grade: " +grade;
    }
}
