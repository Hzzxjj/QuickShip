/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobox1;

/**
 *
 * @author hanan
 */

import java.util.Scanner;


public class QuickShip {
    public static void main(String[] args) {
        
               Scanner scanner = new Scanner(System.in);
        String  address, city, userType, paymentMethod;
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;
        boolean registered = false;
        String username = "";
        String password = "";
        
        while (true) {
            System.out.println("\n Welcome to the QuickShip!");
            System.out.println("1. Sign in");
            System.out.println("2. Register");
            System.out.println("3- Create delivery request");
            System.out.println("4- update account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    if (registered) {
                        System.out.print("Enter your username: ");
                        String inputUsername = input.next();
                        System.out.print("Enter your password: ");
                        String inputPassword = input.next();
                        
                        if (inputUsername.equals(username) && inputPassword.equals(password)) {
                            System.out.println("You are now logged in!");
                            loggedIn = true;
                        } else {
                            System.out.println("Incorrect username or password.");
                        }
                    } else {
                        System.out.println("You need to sign up first.");
                    }
                    break;
                case 2:
             System.out.println("Please create a new account.");
                 System.out.print("Enter your desired username: ");
                    username = input.next();
                    System.out.print("Enter your desired password: ");
                    password = input.next();
                    System.out.println("Please enter your city:");
                    city = scanner.nextLine();
                    System.out.println("Are you an individual or a company?");
                    userType = scanner.nextLine();
                                        registered = true;
                                        System.out.println("You are now registered!");

                    break;

                case 3:
                                        if(loggedIn){

     System.out.println("Welcome back, " + username + "!");
      System.out.println("Please select a payment method (credit card, paypal, or cash):");
                    paymentMethod = scanner.nextLine();
                    
                          System.out.println("Thanks for using QuickShip we will start working on your delivery"
                                  + "and sends you updates ):");}

                                  else {
                        System.out.println("You need to log in first.");
                    }
                          
                                break;

                    
                case 4:
     
                        // Update account
                    if(loggedIn){
                    System.out.println("Please enter your new address:");
                    address = scanner.nextLine();

                    System.out.println("Please enter your new city:");
                    city = scanner.nextLine();

                    System.out.println("Are you an individual or a company?");
                    userType = scanner.nextLine();}
                    
                    else {
                        System.out.println("You need to log in first.");
                    }

                    break;
                   
                    
                           case 5:
       System.out.println("Hope you enjoyed your experience, QuickShip thanks you");
                    System.exit(0);
                    break;
                               
                      
                default:
                    System.out.println("Invalid choice.");
                    break;
                    
       
                    
            }
            
       
     
                
                
            }
        }
    }

