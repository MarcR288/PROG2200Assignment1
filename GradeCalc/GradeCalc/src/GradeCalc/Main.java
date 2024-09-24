package GradeCalc;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GetGrades getgrades = new GetGrades(); //creates an instance of GetGrades / creates new object of the GetGrades class
        ArrayList<Integer> combinedGrades = getgrades.getCombinedGrades(); //calls the getCombinedGrades() methodfrom the getgrades object
        CalculateFinalGrade calculateFinalGrade = new CalculateFinalGrade(combinedGrades); //creates an instance of the CalculateFinalGrade / initializes a new object of the CalculateFinalGrade class
        getgrades.displayCombinedGrades();
        calculateFinalGrade.displayFinalGrade();
        calculateFinalGrade.displayLetterGrade();
    }
}