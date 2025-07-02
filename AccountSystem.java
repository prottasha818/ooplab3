import java.util.*;

public class AccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] account = new Account[60];
        int x = 0;

        while (true) {
            System.out.println("0->Exit");
            System.out.println("1->Create New Account");
            System.out.println("2->Credit/Debit");
            System.out.println("3->Transfer");
            System.out.println("4->View Account");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;
            else if (choice == 1) {
                System.out.println("Enter your account type (current/savings/deposit):");
                String accountType = scanner.nextLine().trim().toLowerCase();
                System.out.println("Enter account name:");
                String name = scanner.nextLine();
                System.out.println("Enter account ID:");
                String id = scanner.nextLine();
                System.out.println("Enter initial balance:");
                double balance = scanner.nextDouble();
                scanner.nextLine();

                if (accountType.equals("current"))
                    account[x++] = new CurrentAccount(name, id, balance, accountType);
                else if (accountType.equals("savings"))
                    account[x++] = new SavingsAccount(id, name, balance, accountType);
                else if (accountType.equals("deposit"))
                    account[x++] = new FixedDepositAccount(id, name, balance, accountType);
                else
                    System.out.println("Invalid account type.");
            }
            else if (choice == 2) {
                System.out.println("Enter account ID:");
                String id = scanner.nextLine();
                Account acc = null;
                for (int i = 0; i < x; i++) {
                    if (account[i].ID.equals(id)) {
                        acc = account[i];
                        break;
                    }
                }
                if (acc != null) {
                    System.out.println("Enter amount:");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Credit (c) or Debit (d)?");
                    String action = scanner.nextLine().toLowerCase();
                    if (action.equals("c")) acc.credit(amt);
                    else if (action.equals("d")) acc.debit(amt);
                } else {
                    System.out.println("Account not found.");
                }
            }
            else if (choice == 3) {
                System.out.println("Enter source ID:");
                String fromID = scanner.nextLine();
                System.out.println("Enter destination ID:");
                String toID = scanner.nextLine();
                System.out.println("Enter amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                Account from = null, to = null;
                for (int i = 0; i < x; i++) {
                    if (account[i].ID.equals(fromID)) from = account[i];
                    if (account[i].ID.equals(toID)) to = account[i];
                }

                if (from != null && to != null) {
                    if (from.accType.equals("deposit"))
                        System.out.println("Transfer not allowed from deposit account.");
                    else
                        from.transferTo(amount, to);
                } else {
                    System.out.println("Account not found.");
                }
            }
            else if (choice == 4) {
                System.out.println("Enter account ID:");
                String id = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < x; i++) {
                    if (account[i].ID.equals(id)) {
                        System.out.println(account[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Account not found.");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}