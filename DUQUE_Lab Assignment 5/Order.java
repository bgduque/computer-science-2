/// Immutable order data carrier (Java record).
public record Order(String customerName, String address, double price, int quantity) { }
