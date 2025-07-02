class FixedDepositAccount extends Account {
    private int creditCount = 0;

    public FixedDepositAccount() {}

    public FixedDepositAccount(String id, String name, double balance, String accType) {
        super(id, name, balance, accType);
    }

    @Override
    public double credit(double amount) {
        balance = interest(balance);
        balance += amount;
        creditCount++;
        return balance;
    }

    @Override
    public double debit(double amount) {
        if (creditCount < 5) {
            System.out.println("Withdrawal not permitted");
        } else {
            balance -= amount;
        }
        return balance;
    }

    @Override
    public double interest(double balance) {
        return balance * 1.07;
    }
}