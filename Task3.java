import java.util.Scanner;


public class ATMSystem {

    // 1. Class to represent the User's Bank Account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        // Method to handle deposits with validation
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.printf("Successfully deposited Rs%.2f\n", amount);
            } else {
                System.out.println("Error: Deposit amount must be positive.");
            }
        }

        // Method to handle withdrawals with validation
        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Error: Invalid withdrawal amount.");
                return false;
            }
            if (amount > balance) {
                System.out.println("Error: Insufficient funds for this withdrawal.");
                return false;
            }
            
            balance -= amount;
            System.out.printf("Successfully withdrew Rs%.2f\n", amount);
            return true;
        }
    }

    // 2. Class to represent the ATM Machine Interface
    static class ATM {
        private BankAccount userAccount;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.userAccount = account;
            this.scanner = new Scanner(System.in);
        }

        public void start() {
            int choice = 0;

            System.out.println("Welcome to the Automated Teller Machine.");

            while (choice != 4) {
                System.out.println("\n---------- ATM MENU ----------");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Cash");
                System.out.println("3. Deposit Funds");
                System.out.println("4. Exit");
                System.out.print("Please select an option (1-4): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); 
                    continue;
                }

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Current Balance: Rs%.2f\n", userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wAmount = scanner.nextDouble();
                        userAccount.withdraw(wAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double dAmount = scanner.nextDouble();
                        userAccount.deposit(dAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the user's account with a starting balance
        BankAccount myAccount = new BankAccount(1000.00);

        ATM atm = new ATM(myAccount);

        
        atm.start();
    }
}