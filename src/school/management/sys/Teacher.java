package school.management.sys;

public class Teacher {

    private int id;
    private String name;
    private int salary;


    public Teacher(int ID, String name, int salary){

        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int payChange){
        salary+=payChange;
        School.addExpenses(payChange);
    }

}
