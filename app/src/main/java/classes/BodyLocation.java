package classes;

import java.util.ArrayList;

public abstract class BodyLocation {
    private ArrayList<Problem> problems = new ArrayList<>();

    // Problem func
    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public void deleteProblem(Problem problem){
        problems.remove(problem);
    }

}
