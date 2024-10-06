import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private double balance;
    private String pin;//1234 Initial Pin
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the ATM with a balance and pin
    public ATM(double initialBalance, String initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check the account balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // Method to withdraw cash
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("You have withdrawn: $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        }
    }

    // Method to deposit cash
    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have deposited: $" + amount);
        transactionHistory.add("Deposited: $" + amount);
    }

    // Method to change the PIN
    public void changePin(String newPin) {
        pin = newPin;
        System.out.println("Your PIN has been changed successfully.");
        transactionHistory.add("Changed PIN");
    }

    // Method to display the transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to validate the entered PIN
    // PIN=1234
    public boolean validatePin(String enteredPin) {
        return enteredPin.equals(pin);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM myATM = new ATM(1000.00, "1234");

        // Main program loop
        while (true) {
            System.out.println("\nATM Machine");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.print("Enter your PIN: ");
                    String pinCheck = scanner.next();
                    if (myATM.validatePin(pinCheck)) {
                        myATM.checkBalance();
                    } else {
                        System.out.println("Invalid PIN.");
                    }
                    break;
                case 2:
                    // Withdraw cash
                    System.out.print("Enter your PIN: ");
                    String pinWithdraw = scanner.next();
                    if (myATM.validatePin(pinWithdraw)) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        myATM.withdraw(amount);
                    } else {
                        System.out.println("Invalid PIN.");
                    }
                    break;
                case 3:
                    // Deposit cash
                    System.out.print("Enter your PIN: ");
                    String pinDeposit = scanner.next();
                    if (myATM.validatePin(pinDeposit)) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        myATM.deposit(amount);
                    } else {
                        System.out.println("Invalid PIN.");
                    }
                    break;
                case 4:
                    // Change PIN
                    System.out.print("Enter your old PIN: ");
                    String oldPin = scanner.next();
                    if (myATM.validatePin(oldPin)) {
                        System.out.print("Enter your new PIN: ");
                        String newPin = scanner.next();
                        myATM.changePin(newPin);
                    } else {
                        System.out.println("Invalid PIN.");
                    }
                    break;
                case 5:
                    // Print transaction history
                    System.out.print("Enter your PIN: ");
                    String pinHistory = scanner.next();
                    if (myATM.validatePin(pinHistory)) {
                        myATM.printTransactionHistory();
                    } else {
                        System.out.println("Invalid PIN.");
                    }
                    break;
                case 6:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}