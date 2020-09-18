package Work;

import java.util.ArrayList;

public class ContractorWorkflow {

    public static void main(String[] args) {

        Estimator Mark = new Estimator("Mark", 70000);
        Estimator Natalie = new Estimator("Natalie", 70000);

        ArrayList<Estimator> estimatorArrayList = new ArrayList<>();
        estimatorArrayList.add(Mark);
        estimatorArrayList.add(Natalie);

        Project ODB = new Project("ODB", 14000000);

        Mark.bidProject(Mark, ODB);


    }

}
