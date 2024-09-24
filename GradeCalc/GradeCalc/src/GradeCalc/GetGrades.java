package GradeCalc;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class GetGrades {
    private Scanner scanner = new Scanner(System.in);
    private int[] homeworkGrades = new int[5];
    private int[] quizGrades = new int[6];
    private int[] topFiveQuizGrades = new int[5];
    private int prelimGrade;
    private int finalGrade;
    ArrayList<Integer> combinedGrades = new ArrayList<>();


    // Constructor to get grades from user
    public GetGrades() {
        getGradesFromUser();
        getPrelimGradeFromUser();
        getFinalGradeFromUser();
        getQuizfromuser();
        combineGrades();
    }

    // Method to get homework grades from user
    private void getGradesFromUser() {
        for (int i = 0; i < homeworkGrades.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter grade for homework assignment " + (i + 1) + ": ");
                    homeworkGrades[i] = scanner.nextInt(); // Use nextInt() for integer input

                    if (homeworkGrades[i] < 0 || homeworkGrades[i] > 100) {
                        throw new IllegalArgumentException("Grade must be within 0 and 100.");
                    }

                    validInput = true; // Mark valid input for the grade

                    // Check if homework was submitted on time
                    boolean validAnswer = false; // To validate Y/N input
                    while (!validAnswer) {
                        System.out.println("Was the homework submitted on time? (Y/N)");
                        String answer = scanner.next().trim().toUpperCase();
                        if (answer.equals("Y")) {
                            validAnswer = true; // Accept the answer
                        } else if (answer.equals("N")) {
                            // Ask about late submission
                            boolean lateAnswerValid = false; // Validate late submission input
                            while (!lateAnswerValid) {
                                System.out.println("Was the homework submitted within 24 hours of the deadline? (Y/N)");
                                answer = scanner.next().trim().toUpperCase();
                                if (answer.equals("Y")) {
                                    homeworkGrades[i] = Math.max(0, homeworkGrades[i] - 10); //Submitted Within 24 hours past due date is -10%
                                    lateAnswerValid = true; // Accept the answer
                                } else if (answer.equals("N")) {
                                    homeworkGrades[i] = Math.max(0, homeworkGrades[i] - 25); //Submitted after 24 hours past due date is -25%
                                    lateAnswerValid = true; // Accept the answer
                                } else {
                                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                                }
                            }
                            validAnswer = true; // Move on to the next grade
                        } else {
                            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                        }
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Enter an integer.");
                    scanner.next(); // Clear the invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    //method to get prelim grade from user
    public void getPrelimGradeFromUser() {
        boolean validInput = false; // Flag to track valid input
        while (!validInput) { // Keep asking until valid input is received
            try {
                System.out.println("Enter Prelim grade:");
                prelimGrade = scanner.nextInt(); // Read input

                // Check if the grade is within the valid range
                if (prelimGrade < 0 || prelimGrade > 100) {
                    throw new IllegalArgumentException("Prelim grades must be within 0 and 100.");
                }

                validInput = true; // Mark input as valid
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //method to get final grade from user
    public void getFinalGradeFromUser() {
        boolean validInput = false; // Flag to track valid input
        while (!validInput) { // Keep asking until valid input is received
            try {
                System.out.println("Enter a grade for the Final:");
                finalGrade = scanner.nextInt(); // Read input

                // Check if the grade is within the valid range
                if (finalGrade < 0 || finalGrade > 100) {
                    throw new IllegalArgumentException("Prelim grades must be within 0 and 100.");
                }

                validInput = true; // Mark input as valid
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Enter an integer.");
                scanner.next(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //method to get quiz grades from user
    public void getQuizfromuser() {
        for (int i = 0; i < quizGrades.length; i++) { // Change to quizgrades.length
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter grade for quiz number " + (i + 1) + ": ");
                    quizGrades[i] = scanner.nextInt();

                    if (quizGrades[i] < 0 || quizGrades[i] > 100) {
                        throw new IllegalArgumentException("Grade must be within 0 and 100.");
                    }

                    validInput = true; // Mark input as valid after successfully reading it
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Enter an integer.");
                    scanner.next(); // Clear the invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        dropLowestGrade();
    }

    //method to drop lowest quiz grade by sorting it and adding all the values (starting at index 1) to a new array topFiveQuizGrades
    public void dropLowestGrade(){
        Arrays.sort(quizGrades);
        for (int i = 1; i < quizGrades.length; i++) {
            topFiveQuizGrades[i - 1] = quizGrades[i];
        }
    }

    //prints to the console all the grades eneterd
    public void displayCombinedGrades(){
        System.out.println("All Grades: ");
        for (int grade : combinedGrades) {
            System.out.println(grade);
        }
    }

    //method to combine all grades into one ArrayList
    public void combineGrades(){
        int totalLength = homeworkGrades.length + topFiveQuizGrades.length + 2;

        for (int value : homeworkGrades) {
            combinedGrades.add(value);
        }

        for (int value : topFiveQuizGrades) {
            combinedGrades.add(value);
        }

        combinedGrades.add(prelimGrade);
        combinedGrades.add(finalGrade);
    }

    //Getter
    public ArrayList<Integer> getCombinedGrades(){
        return combinedGrades;
    }
}