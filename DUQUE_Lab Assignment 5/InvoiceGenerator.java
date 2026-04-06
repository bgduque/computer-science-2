/// Generates an invoice document for an order.
public interface InvoiceGenerator {
    void generateInvoice(Order order, String fileName);
}
