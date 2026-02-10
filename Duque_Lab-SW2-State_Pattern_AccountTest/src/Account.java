/**
 * Account class represents a bank account with state management.
 * Uses the State Pattern to delegate behavior to the current state object.
 * No if-else or switch statements are used for state-specific logic.
 */
public class Account {

    private final String accountNumber;
    private Double balance;
    private AccountState accountState;

    /**
     * Creates a new Account with the specified account number and initial balance.
     * The account starts in Active state.
     *
     * @param accountNumber the unique account identifier
     * @param balance the initial balance
     */
    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountState = new ActiveState();
    }

    /**
     * Deposits the specified amount into the account.
     * Behavior depends on the current state.
     *
     * @param depositAmount the amount to deposit
     */
    public void deposit(Double depositAmount) {
        accountState.deposit(depositAmount, this);
    }

    /**
     * Withdraws the specified amount from the account.
     * Behavior depends on the current state.
     *
     * @param withdrawAmount the amount to withdraw
     */
    public void withdraw(Double withdrawAmount) {
        accountState.withdraw(withdrawAmount, this);
    }

    /**
     * Suspends the account.
     * Behavior depends on the current state.
     */
    public void suspend() {
        accountState.suspend(this);
    }

    /**
     * Activates the account.
     * Behavior depends on the current state.
     */
    public void activate() {
        accountState.activate(this);
    }

    /**
     * Closes the account.
     * Behavior depends on the current state.
     */
    public void close() {
        accountState.close(this);
    }

    // Getters and Setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    /**
     * Returns a string representation of the account.
     * Displays account number, balance, and current status.
     *
     * @return formatted account information
     */
    @Override
    public String toString() {
        return "Account [Number: %s, Balance: %.2f, Status: %s]".formatted(
            accountNumber,
            balance,
            accountState.getStateName()
        );
    }
}

