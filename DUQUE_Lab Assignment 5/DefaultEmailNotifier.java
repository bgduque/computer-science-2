/// Default implementation that simulates sending an email.
public class DefaultEmailNotifier implements EmailNotifier {

    @Override
    public void sendNotification(String email, Order order) {
        System.out.println("Email notification sent to: " + email);
    }
}
