import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Enter student grades (enter -1 to stop):");
        while (true) {
            System.out.print("Enter grade: ");
            if (scanner.hasNextInt()) {
                int grade = scanner.nextInt();
                if (grade == -1) break;
                grades.add(grade);
            } else {
                System.out.println("Invalid input. Please enter an integer grade.");
                scanner.next(); // Consume the invalid input
            }
        }
        
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            int highest = getHighest(grades);
            int lowest = getLowest(grades);
            double average = getAverage(grades);
            
            System.out.println("\nGrade Summary:");
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
            System.out.printf("Average Grade: %.2f\n", average);
        }
        
        scanner.close();
    }
    
    private static int getHighest(ArrayList<Integer> grades) {
        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return max;
    }
    
    private static int getLowest(ArrayList<Integer> grades) {
        int min = grades.get(0);
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return min;
    }
    
    private static double getAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
