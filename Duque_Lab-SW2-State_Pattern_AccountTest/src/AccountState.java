/**
 * AccountState interface defines the contract for all account states.
 * Each state must implement behavior for deposit, withdraw, activate, suspend, and close operations.
 */
public sealed interface AccountState permits ActiveState, SuspendedState, ClosedState {

    void deposit(Double amount, Account account);
    void withdraw(Double amount, Account account);
    void activate(Account account);
    void suspend(Account account);
    void close(Account account);
    String getStateName();
}

