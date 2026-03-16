public class Sofa implements Furniture {
    private double volume;
    private double shippingDistanceMiles;

    public Sofa(double volume, double shippingDistanceMiles) {
        this.volume = volume;
        this.shippingDistanceMiles = shippingDistanceMiles;
    }

    public double getVolume() {
        return volume;
    }

    public double getShippingDistanceMiles() {
        return shippingDistanceMiles;
    }

    @Override
    public void accept(ShippingCostVisitor visitor) {
        visitor.visit(this);
    }
}
