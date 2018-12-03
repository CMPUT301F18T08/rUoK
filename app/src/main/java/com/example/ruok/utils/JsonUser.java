package com.example.ruok.utils;

import java.util.ArrayList;

import classes.Problem;
import classes.User;

/**
 * @Date 2018-11-30.
 */
public class JsonUser extends User {

    private ArrayList<Problem> problems = new ArrayList<Problem>();
    private ArrayList<JsonUser> patients = new ArrayList<>();

    public ArrayList<Problem> getProblems() {
        return problems;
    }

    public void setProblems(ArrayList<Problem> problems) {
        this.problems = problems;
    }

    public ArrayList<JsonUser> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<JsonUser> patients) {
        this.patients = patients;
    }
}
