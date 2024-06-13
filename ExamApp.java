package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ExamApp {
    private static final UserService userService = new UserService();
    private static final ExamService examService = new ExamService();
    private static User currentUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (currentUser == null) {
            System.out.println("Welcome to Online Exam! Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String userName = scanner.next();
                    System.out.println("Enter password:");
                    String password = scanner.next();
                    userService.registerUser(userName, password);
                    break;
                case 2:
                    System.out.println("Enter user name:");
                    userName = scanner.next();
                    System.out.println("Enter password:");
                    password = scanner.next();
                    currentUser = userService.authenticateUser(userName, password);
                    if (currentUser == null) {
                        System.out.println("Authentication failed. Please try again.");
                    } else {
                        System.out.println("Login successful.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter new profile details:");
                    String newProfile = scanner.next();
                    userService.updateProfile(currentUser, newProfile);
                    break;
                case 2:
                    System.out.println("Enter new password:");
                    String newPassword = scanner.next();
                    userService.updatePassword(currentUser, newPassword);
                    break;
                case 3:
                    startExam();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void startExam() {
        List<Question> questions = examService.getQuestions();
        List<Integer> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Submitting your answers...");
                int score = examService.submitAnswers(currentUser, answers);
                System.out.println("You scored: " + score + "/" + questions.size());
                System.exit(0);
            }
        }, 60000); // 60 seconds for the exam

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println("1. " + question.getOption1());
            System.out.println("2. " + question.getOption2());
            System.out.println("3. " + question.getOption3());
            System.out.println("4. " + question.getOption4());
            System.out.print("Select your answer: ");
            int answer = scanner.nextInt();
            answers.add(answer);
        }

        timer.cancel(); // Cancel the timer if the user finishes before time's up
        int score = examService.submitAnswers(currentUser, answers);
        System.out.println("You scored: " + score + "/" + questions.size());
    }
}
