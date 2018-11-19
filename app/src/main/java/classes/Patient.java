package classes;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private ArrayList<Problem> problems = new ArrayList<Problem>();

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public void editProblem(Problem problem,String title, Date date,String description){
        problem.setTitle(title);
        problem.setDate(date);
        problem.setDescription(description);
    }

    public void deleteProblem(Problem problem){
        problems.remove(problem);
    }

    public void addRecord(Problem problem, Record record){
        problem.addRecord(record);
    }

}
