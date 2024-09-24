package GradeCalc;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class CalculateFinalGrade {
    private double finalGrade;
    private ArrayList<Integer> combinedGrades;
    private String letterGrade;

    // Constructor that takes combined grades
    public CalculateFinalGrade(ArrayList<Integer> combinedGrades) {
        this.combinedGrades = combinedGrades; // Assign the passed grades
        this.finalGrade = calculateFinalGrade(combinedGrades); // Calculate final grade upon initialization
        calculateMinimumLetterGrade();
    }

    // Calculate final grade as a static method
    public static double calculateFinalGrade(ArrayList<Integer> combinedGrades) {
        if (combinedGrades == null || combinedGrades.isEmpty()) {
            return 0; // Avoid division by zero
        }

        double sum = 0;
        for (int grade : combinedGrades) {
            sum += grade; // Sum all grades
        }
        return sum / combinedGrades.size(); // Calculate and return the final grade
    }

    // Display the final grade
    public void displayFinalGrade() {
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println("Your final course score: " + df.format(finalGrade)); // Use the calculated final grade
    }

    //Switch case to assign letter grade
    public void  calculateMinimumLetterGrade(){
        int gradeBracket = (int) (finalGrade / 10);
        switch (gradeBracket){
            case 10: // 100
            case 9:  // 90-99
                letterGrade = "A+";
                break;
            case 8:  // 80-89
                letterGrade = "A";
                break;
            case 7:  // 70-79
                letterGrade = "B";
                break;
            case 6:  // 60-69
                letterGrade = "C";
                break;
            case 5:  // 50-59
                letterGrade = "D";
                break;
            case 4:  // 40-49
            case 3:  // 30-39
            case 2:  // 20-29
            case 1:  // 10-19
            case 0:  // 0-9
                letterGrade = "F";
                break;
            default: // Handle invalid grades
                letterGrade = "Invalid grade";
                break;
        }

    }

    //Displays minimum letter grade
    public void displayLetterGrade() {
        System.out.println("Your letter grade will be at least: " + letterGrade);
    }
}
