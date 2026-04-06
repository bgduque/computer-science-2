/// Sends an email notification about an order.
public interface EmailNotifier {
    void sendNotification(String email, Order order);
}
