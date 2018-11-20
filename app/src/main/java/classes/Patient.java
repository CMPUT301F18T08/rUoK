package classes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Patient class
 * @author  Yuhan Ye
 * @version 1.1
 */
public class Patient extends User {
    private ArrayList<Problem> problems = new ArrayList<Problem>();

    /**
     * method to get the list of problems
     * @return problems
     */
    public ArrayList<Problem> getProblems() {
        return problems;
    }

    /**
     * method to add problem to problem list
     * @param problem
     */
    public void addProblem(Problem problem){
        problems.add(problem);
    }

    /**
     * method to edit problem's title,date and description
     * @param problem
     * @param title problem title
     * @param date  date is self-generated at the time of hitting save
     * @param description this is the problem description
     */
    public void editProblem(Problem problem,String title, Date date,String description){
        problem.setTitle(title);
        problem.setDate(date);
        problem.setDescription(description);
    }

    /**
     * method to delete problem from problem list
     * @param problem
     */
    public void deleteProblem(Problem problem){
        problems.remove(problem);
    }

    /**
     * method to add record to problem
     * @param problem
     * @param record
     */
    public void addRecord(Problem problem, Record record){
        problem.addRecord(record);
    }

}
