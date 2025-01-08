import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
        return true;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void changePin(String newPin) {
        this.pin = newPin;
    }
}

public class ATM {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Account> accounts = new HashMap<>();

    static {
        accounts.put("123456", new Account("123456", "1234", 1000.00));
        accounts.put("654321", new Account("654321", "4321", 2000.00));
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Welcome to the ATM Interface!");
        System.out.println("Date and Time: " + dtf.format(now));

        String[] messages = {
            "Have a great day ahead!",
            "You're doing amazing work!",
            "Stay positive, and success will follow!",
            "Keep pushing forward!",
            "Thank you for choosing us today!"
        };

        int randomIndex = (int) (Math.random() * messages.length);
        System.out.println(messages[randomIndex] + "\n");

        while (true) {
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();

            Account account = accounts.get(accountNumber);
            if (account == null) {
                System.out.println("\nInvalid Account Number!\n");
                continue;
            }

            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            if (!account.authenticate(pin)) {
                System.out.println("\nInvalid PIN!\n");
                continue;
            }

            System.out.println("\nLogin Successful!\n");
            performOperations(account);
        }
    }

    private static void performOperations(Account account) {
        while (true) {
            System.out.println("Select an Option:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit\n");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\nCurrent Balance: $" + account.getBalance() + "\n");
                    break;
                case 2:
                    System.out.print("\nEnter deposit amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                    System.out.println("\nDeposited $" + depositAmount + " successfully!\n");
                    break;
                case 3:
                    System.out.print("\nEnter withdrawal amount: ");
                    double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("\nWithdrew $" + withdrawalAmount + " successfully!\n");
                    } else {
                        System.out.println("\nInsufficient Balance!\n");
                    }
                    break;
                case 4:
                    System.out.println("\nTransaction History:");
                    for (String transaction : account.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("\nEnter new PIN: ");
                    String newPin = scanner.nextLine();
                    account.changePin(newPin);
                    System.out.println("\nPIN changed successfully!\n");
                    break;
                case 6:
                    System.out.println("\nThank you for using the ATM. Goodbye!\n");
                    return;
                default:
                    System.out.println("\nInvalid choice!\n");
            }
        }
    }
}
