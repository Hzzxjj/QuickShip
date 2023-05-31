/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickship1;
import java.util.*;
/**
 *
 * @author hanan
 */
class Account {
    private static int count = 0; // Static counter to assign unique IDs to accounts
    private int id;
    private String username;
    private String password;
    private String phone;
  public Account(String username, String password, String phone) {
        this.id = count++;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
  public Account() {
        this.id = count++;
        this.username = "";
        this.password = "";
        this.phone = "";
    }

  public String getUsername() {
        return username;
    }
  public void setUsername(String username) {
        this.username = username;
    }
  public String getPassword() {
        return password;
    }
  public void setPassword(String password) {
        this.password = password;
    }
  public String getPhone() {
        return phone;
    }
  public void setPhone(String phone) {
        this.phone = phone;
    }


}

class Warehouse {
    public void setName(String name) {
        this.name = name;
    }
  public void setLocation(String location) {
        this.location = location;
    }
  private String name;
    private String location;
  public Warehouse(String name, String location) {
        this.name = name;
        this.location = location;
    }
  public String getName() {
        return name;
    }
  public String getLocation() {
        return location;
    }
}

class Carrier {
    public void setName(String name) {
        this.name = name;
    }
  public void setLocation(String location) {
        this.location = location;
    }
  private String name;
    private String location;
  public Carrier(String name, String location) {
        this.name = name;
        this.location = location;
    }
  public String getName() {
        return name;
    }
  public String getLocation() {
        return location;
    }
}

class Shipment {
    private static int count = 0; // Static counter to assign unique IDs to shipments
    private int id;
    private Warehouse warehouse;
    private Carrier carrier;
  public static int getCount() {
        return count;
    }
  public static void setCount(int count) {
        Shipment.count = count;
    }
  public void setId(int id) {
        this.id = id;
    }
  public Warehouse getWarehouse() {
        return warehouse;
    }
  public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
  public Carrier getCarrier() {
        return carrier;
    }
  public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
  public Date getShipmentDate() {
        return shipmentDate;
    }
  public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
  public boolean isDelivered() {
        return isDelivered;
    }
  public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
  private Date shipmentDate;
    private boolean isDelivered;
  public Shipment(Warehouse warehouse, Carrier carrier, Date shipmentDate) {
        this.id = ++count;
        this.warehouse = warehouse;
        this.carrier = carrier;
        this.shipmentDate = shipmentDate;
        this.isDelivered = false;
    }
  public int getId() {
        return id;
    }
  public void trackShipment() {
        System.out.println("Tracking shipment " + id + "...");
        System.out.println("Shipment " + id + " is in transit.");
    }
  public void markAsDelivered() {
        this.isDelivered = true;
        System.out.println("Shipment " + id + " marked as delivered.");
    }
}

class Payment {
    public Shipment getShipment() {
        return shipment;
    }
  public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
  public double getAmount() {
        return amount;
    }
  public void setAmount(double amount) {
        this.amount = amount;
    }
  public boolean isPaid() {
        return isPaid;
    }
  public void setPaid(boolean paid) {
        isPaid = paid;
    }
  private Shipment shipment;
    private double amount;
    private boolean isPaid;
  public Payment(Shipment shipment, double amount) {
        this.shipment = shipment;
        this.amount = amount;
        this.isPaid = false;
    }
  public void processPayment(String paymentMethod) {
        System.out.println("Processing payment for shipment " + shipment.getId() + "...");
        System.out.println("Payment processed successfully with " + paymentMethod + ".");
        shipment.markAsDelivered();
    }
}

public class QuiqShip {
    static ArrayList<Account> accounts = new ArrayList<Account>();
    private static String username = "";
    private static String password = "";
    private static boolean loggedIn = false;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Shipment> shipments = createMockData(); // Create mock shipments
    private static Warehouse warehouse = new Warehouse("Warehouse A", "Location A");
    private static Carrier carrier = new Carrier("Carrier X", "Location X");
  public static void main(String[] args) {
        int choice = 0;

      while (choice != 5) {
            // Display menu options
            System.out.println("Welcome to QuickShip !!");
            System.out.println("1. Register");
            System.out.println("2. Log in");
            System.out.println("3. Create delivery request");
            System.out.println("4. Process Payment and Mark as Delivered");
          System.out.println("5. Update Account");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
          try {
                choice = Integer.parseInt(scanner.nextLine()); // Read user input
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }
          switch (choice) {
                case 1:
                  registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    if (!loggedIn) {
                        System.out.println("\n\n########################");
                        System.out.println("Please log in first.");
                        System.out.println("########################\n\n");
                        continue;
                    }
                    createShipment();
                    break;
                case 4:
                    if (!loggedIn) {
                        System.out.println("\n\n########################");
                        System.out.println("Please log in first.");
                        System.out.println("########################\n\n");
                        continue;
                    }
                    processPaymentAndMarkAsDelivered();
                    break;
                case 5:
                  updateAccount();
                  break;
              case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
          System.out.println();
        }
      scanner.close();
    }
  private static boolean checkUserIsExists(String usermame) {
        for (Account account : accounts) {
            if (account.getUsername().equals(usermame)) {
                System.out.println("User is already exists");
                return true;
            }
        }
        return false;
  }
  private static void registerUser() {
        Account account = new Account();
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
      while (checkUserIsExists(username)) {
            System.out.println("This username is already taken. Please enter another username:");
            username = scanner.nextLine();
        }
      account.setUsername(username);
      System.out.println("Enter your password: ");
        password = scanner.nextLine();
      account.setPassword(password);
        System.out.println("Enter your phone: ");
        String phone = scanner.nextLine();
        account.setPhone(phone);
        accounts.add(account);

      System.out.println("Registration successful!");

      // Store user information in database or perform necessary actions
    }
  private static void loginUser() {
        System.out.println("Enter your username: ");
        String name = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(name) && account.getPassword().equals(pass)) {
                loggedIn = true;
                System.out.println("Login successful!");
                return;
          }
        }
        System.out.println("Invalid username or password. Please try again.");

  }
  private static void createShipment() {
        System.out.println("To which city would you like to receive the shipment? ");
        String city = scanner.nextLine();
        System.out.println("What is your address? ");
        String address = scanner.nextLine();
        System.out.println("Write your address details (villa, apartment): ");
        String addressDetails = scanner.nextLine();
      String fullAddress = address + ", " + addressDetails + ", " + city;
      Date currentDate = new Date();
        Shipment newShipment = new Shipment(warehouse, carrier, currentDate);
        newShipment.setId(generateRandomNumber());
        shipments.add(newShipment);
        System.out.println("Shipment " + newShipment.getId() + " created successfully.");
        System.out.println("Your shipment will be delivered to:");
        System.out.println(fullAddress);
    }
  private static void processPaymentAndMarkAsDelivered() {
        System.out.println("Enter the ID of the shipment for payment processing: ");
        int shipmentId = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
      for (Shipment shipment : shipments) {
            if (shipment.getId() == shipmentId) {
                System.out.println("What is your payment method (credit card, PayPal, cash)? ");
                String paymentMethod = scanner.nextLine();
              Payment payment = new Payment(shipment, 100.00);
                payment.processPayment(paymentMethod); // Process payment for the selected shipment
                return;
            }
        }
      System.out.println("Shipment " + shipmentId + " not found.");
    }
  // Method to generate a random number for shipment ID
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }
  // Method to create mock shipments for testing
    private static List<Shipment> createMockData() {
        List<Shipment> shipments = new ArrayList<>();
      Warehouse warehouse = new Warehouse("Warehouse A", "Location A");
        Carrier carrier = new Carrier("Carrier X", "Location X");
      // Create and add mock shipments
        Shipment shipment1 = new Shipment(warehouse, carrier, new Date());
        shipments.add(shipment1);
      Shipment shipment2 = new Shipment(warehouse, carrier, new Date());
        shipments.add(shipment2);
      Shipment shipment3 = new Shipment(warehouse, carrier, new Date());
        shipments.add(shipment3);
      return shipments;
    }
  private static void updateAccount() {
        System.out.println("Enter your username: ");
        String name = scanner.nextLine();
        while (!checkUserIsExists(username)) {
            System.out.println("This username not found. Please enter another username:");
            username = scanner.nextLine();
        }

      System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(name) && account.getPassword().equals(pass)) {
//        update account
                System.out.println("Enter your new username: ");
                String newUsername = scanner.nextLine();
                account.setUsername(newUsername);
                System.out.println("Enter your new password: ");
                String newPassword = scanner.nextLine();
                account.setPassword(newPassword);
                System.out.println("Enter your new phone: ");
                String newPhone = scanner.nextLine();
                account.setPhone(newPhone);
                System.out.println("Update successful!");
                return;
          }
        }}
}
