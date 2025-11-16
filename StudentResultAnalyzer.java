import java.util.Scanner;

public class StudentResultAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String names[] = new String[n];
        int marks[] = new int[n];
        char grade[] = new char[n];

        System.out.println("\nEnter student name and marks:");
        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            names[i] = sc.next();
            System.out.print("Marks: ");
            marks[i] = sc.nextInt();

            // Assign Grade
            if (marks[i] >= 90) grade[i] = 'A';
            else if (marks[i] >= 80) grade[i] = 'B';
            else if (marks[i] >= 70) grade[i] = 'C';
            else if (marks[i] >= 60) grade[i] = 'D';
            else grade[i] = 'F';
        }

        // Sorting (Bubble Sort) based on marks (Descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] < marks[j + 1]) {

                    int tempMarks = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempMarks;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    char tempGrade = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = tempGrade;
                }
            }
        }

        // Rank List
        System.out.println("\n--- RANK LIST ---");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + marks[i] + " (" + grade[i] + ")");
        }

        // Highest & Lowest
        System.out.println("\nTopper: " + names[0] + " (" + marks[0] + ")");
        System.out.println("Lowest: " + names[n - 1] + " (" + marks[n - 1] + ")");

        // Top 3 Rankers
        System.out.println("\n--- TOP 3 STUDENTS ---");
        for (int i = 0; i < Math.min(3, n); i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + marks[i]);
        }

        // Class Average
        int sum = 0;
        for (int m : marks) sum += m;
        double average = (double) sum / n;
        System.out.println("\nClass Average: " + average);

        // Pass/Fail
        int pass = 0;
        for (int m : marks) {
            if (m >= 35) pass++;
        }
        int fail = n - pass;
        double passPercent = (pass * 100.0) / n;

        System.out.println("Passed: " + pass);
        System.out.println("Failed: " + fail);
        System.out.println("Pass Percentage: " + passPercent + "%");

        // Search Student
        System.out.print("\nEnter name to search: ");
        String target = sc.next();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("\nResult of " + target + ":");
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade[i]);
                System.out.println("Rank: " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Student not found!");

        sc.close();
    }
}
