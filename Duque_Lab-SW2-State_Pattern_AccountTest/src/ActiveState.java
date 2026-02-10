/**
 * ActiveState represents an active bank account.
 * Allows deposits and withdrawals.
 * Can be suspended or closed.
 */
public final class ActiveState implements AccountState {

    @Override
    public void deposit(Double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited: " + amount);
        System.out.println(account);
    }

    @Override
    public void withdraw(Double amount, Account account) {
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdrew: " + amount);
        System.out.println(account);
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void suspend(Account account) {
        account.setAccountState(new SuspendedState());
        System.out.println("Account is suspended!");
    }

    @Override
    public void close(Account account) {
        account.setAccountState(new ClosedState());
        System.out.println("Account is closed!");
    }

    @Override
    public String getStateName() {
        return "Active";
    }
}

