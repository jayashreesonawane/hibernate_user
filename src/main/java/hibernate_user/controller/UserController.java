package hibernate_user.controller;

import java.util.Scanner;

import hibernate_user.dao.UserDao;
import hibernate_user.dto.User;

public class UserController {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserDao dao = new UserDao();

        System.out.println("Welcome User");
        System.out.println("1. SignUp\n2. LogIn\n3. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                try {
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();

                    System.out.println("Enter name: ");
                    String name = scanner.next();

                    System.out.println("Enter phone: ");
                    long phone = scanner.nextLong();

                    System.out.println("Enter email: ");
                    String email = scanner.next();

                    System.out.println("Enter Password: ");
                    String password = scanner.next();

                    System.out.println("Enter Facebook password :");
                    String facebook = scanner.next();

                    System.out.println("Enter Whatsapp password :");
                    String whatsapp = scanner.next();

                    System.out.println("Enter Instagram password :");
                    String instagram = scanner.next();

                    System.out.println("Enter Snapchat password :");
                    String snapchat = scanner.next();

                    System.out.println("Enter Twitter password :");
                    String twitter = scanner.next();

                    User user = new User();
                    user.setId(id);
                    user.setName(name);
                    user.setPhone(phone);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setFacebook(facebook);
                    user.setWhatsapp(whatsapp);
                    user.setInstagram(instagram);
                    user.setSnapchat(snapchat);
                    user.setTwitter(twitter);

                    dao.signUpUser(user);
                    System.out.println("SignUp Successfully");
                } catch (Exception e) {
                    System.out.println("Error in SignUp");
                }
            }
            break;

            case 2: {
                try {
                    System.out.println("Enter email: ");
                    String email = scanner.next();

                    System.out.println("Enter password: ");
                    String password = scanner.next();

                    User loginUser = dao.loginUser(email, password);
                    if (loginUser != null) {
                        System.out.println("Login successful : " + loginUser);
                        System.out.println("1. Show Passwords \n2. Logout");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                dao.displayPasswords();
                                break;

                            case 2:
                                System.out.println("Logout successful.");
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    } else {
                        System.out.println("Login failed. Invalid email or password.");
                    }
                } catch (Exception e) {
                    System.out.println("Error in Login");
                }
            }
            break;

            default:
                break;
        }

        scanner.close();
    }
}
