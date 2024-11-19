package assignment.assignmentex;

import service.Userservices;
import service.Questioinservice;
import entity.Question;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Userservices userService = new Userservices();
        Questioinservice questionService = new Questioinservice();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Admin Operations");
            System.out.println("2. User Operations");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Admin Operations
                    System.out.print("Enter admin email: ");
                    String adminEmail = sc.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = sc.nextLine();

                    User adminUser = userService.login(adminEmail, adminPassword);
                    if (adminUser != null && "admin".equalsIgnoreCase(adminUser.getRole())) {
                        while (true) {
                            System.out.println("Admin Menu:");
                            System.out.println("1. Add Question");
                            System.out.println("2. View All Questions");
                            System.out.println("3. Delete Question");
                            System.out.println("4. Exit Admin Menu");
                            int adminChoice = sc.nextInt();
                            sc.nextLine();

                            switch (adminChoice) {
                                case 1: // Add Question
                                    System.out.print("Enter question text: ");
                                    String questionText = sc.nextLine();
                                    System.out.print("Enter option A: ");
                                    String optionA = sc.nextLine();
                                    System.out.print("Enter option B: ");
                                    String optionB = sc.nextLine();
                                    System.out.print("Enter option C: ");
                                    String optionC = sc.nextLine();
                                    System.out.print("Enter option D: ");
                                    String optionD = sc.nextLine();
                                    System.out.print("Enter correct answer: ");
                                    String correctAnswer = sc.nextLine();

                                    Question question = new Question(0, questionText, optionA, optionB, optionC, optionD, correctAnswer, adminUser);
                                    questionService.addquestion(question);
                                    System.out.println("Question added successfully!");
                                    break;

                                case 2: // View All Questions
                                    List<Question> questions = questionService.getallquestions();
                                    System.out.println("Questions:");
                                    for (Question q : questions) {
                                        System.out.println(q.getQuestionId() + ": " + q.getQuestionText());
                                    }
                                    break;

                                case 3: // Delete Question
                                    System.out.print("Enter question ID to delete: ");
                                    int questionId = sc.nextInt();
                                    questionService.deleletequestion(questionId);
                                    System.out.println("Question deleted successfully!");
                                    break;

                                case 4:
                                    System.out.println("Exiting Admin Menu...");
                                    break;

                                default:
                                    System.out.println("Invalid choice! Please try again.");
                            }

                            if (adminChoice == 4) break;
                        }
                    } else {
                        System.out.println("Invalid admin credentials or you are not an admin!");
                    }
                    break;

                case 2: // User Operations
                    System.out.println("User Menu:");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    int userChoice = sc.nextInt();
                    sc.nextLine();

                    switch (userChoice) {
                        case 1: // Register
                            System.out.print("Enter name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter password: ");
                            String password = sc.nextLine();
                            System.out.print("Enter role (User/Admin): ");
                            String role = sc.nextLine();

                            if (!role.equalsIgnoreCase("User") && !role.equalsIgnoreCase("Admin")) {
                                System.out.println("Invalid role! Please enter either 'User' or 'Admin'.");
                                break; 
                            }

                            User newUser = new User(0, name, email, password, role.toLowerCase());
                            userService.registeruser(newUser);
                            System.out.println("Registration successful!");
                            break;

                        case 2: // Login
                            System.out.print("Enter email: ");
                            String loginEmail = sc.nextLine();
                            System.out.print("Enter password: ");
                            String loginPassword = sc.nextLine();

                            User loggedInUser = userService.login(loginEmail, loginPassword);
                            if (loggedInUser != null) {
                                System.out.println("Welcome, " + loggedInUser.getName() + "!");
                            } else {
                                System.out.println("Invalid email or password!");
                            }
                            break;

                        case 3:
                            System.out.println("Exiting...");
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Thank you for using the Online Exam System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
