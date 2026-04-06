/// Default implementation that simulates invoice file creation.
public class DefaultInvoiceGenerator implements InvoiceGenerator {

    @Override
    public void generateInvoice(Order order, String fileName) {
        System.out.println("Invoice generated: " + fileName);
    }
}
