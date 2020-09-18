package Work;

import java.util.Random;

public class Estimator {

    private String name;
    private int salary;
    Random rand = new Random();
    int chance = rand.nextInt(2);
    boolean hasProject = false;


    public Estimator(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public void bidProject(Estimator estimator, Project project){
        String estimatorName = estimator.name;
        String projectName = project.projectName;
        if(chance == 0){
            System.out.println(estimatorName + "'s bid on " + projectName + " has been accepted.");
            estimator.hasProject = true;
        } else {
            System.out.println(estimatorName + "'s bid on " + projectName + " has been declined.");
        }
    }

/*    public void winsProject(){

    }*/



}

