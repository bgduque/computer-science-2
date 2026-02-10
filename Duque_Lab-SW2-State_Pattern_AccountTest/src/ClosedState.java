/**
 * ClosedState represents a closed bank account.
 * Disallows all transactions and state changes.
 */
public final class ClosedState implements AccountState {

    @Override
    public void deposit(Double amount, Account account) {
        System.out.println("You cannot deposit on a closed account!");
        System.out.println(account);
    }

    @Override
    public void withdraw(Double amount, Account account) {
        System.out.println("You cannot withdraw on a closed account!");
        System.out.println(account);
    }

    @Override
    public void activate(Account account) {
        System.out.println("You cannot activate a closed account!");
    }

    @Override
    public void suspend(Account account) {
        System.out.println("You cannot suspend a closed account!");
    }

    @Override
    public void close(Account account) {
        System.out.println("Account is already closed!");
    }

    @Override
    public String getStateName() {
        return "Closed";
    }
}

