/**
 * SuspendedState represents a suspended bank account.
 * Disallows deposits and withdrawals, but allows viewing account information.
 * Can be activated or closed.
 */
public final class SuspendedState implements AccountState {

    @Override
    public void deposit(Double amount, Account account) {
        System.out.println("You cannot deposit on a suspended account!");
        System.out.println(account);
    }

    @Override
    public void withdraw(Double amount, Account account) {
        System.out.println("You cannot withdraw on a suspended account!");
        System.out.println(account);
    }

    @Override
    public void activate(Account account) {
        account.setAccountState(new ActiveState());
        System.out.println("Account is activated!");
    }

    @Override
    public void suspend(Account account) {
        System.out.println("Account is already suspended!");
    }

    @Override
    public void close(Account account) {
        account.setAccountState(new ClosedState());
        System.out.println("Account is closed!");
    }

    @Override
    public String getStateName() {
        return "Suspended";
    }
}

