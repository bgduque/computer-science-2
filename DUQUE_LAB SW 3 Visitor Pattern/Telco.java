public class Telco implements TelcoSubscription {

    private int dataAllowance;
    private double promoPrice;
    private String telcoName;
    private boolean unliCallText;

    public Telco(int dataAllowance, double promoPrice, String telcoName, boolean unliCallText) {
        this.dataAllowance = dataAllowance;
        this.promoPrice = promoPrice;
        this.telcoName = telcoName;
        this.unliCallText = unliCallText;
    }

    @Override
    public String accept(UsagePromo promo) {
        return promo.showAllowance(telcoName, promoPrice);
    }

    @Override
    public String accept(UnliCallOffer unli) {
        return unli.showUnliCallsTextOffer(telcoName, unliCallText);
    }

    @Override
    public String getTelcoName() {
        return telcoName;
    }

    @Override
    public double getPromoPrice() {
        return promoPrice;
    }

    @Override
    public boolean getUnliCallText() {
        return unliCallText;
    }

    public int getDataAllowance() {
        return dataAllowance;
    }

    public void setDataAllowance(int dataAllowance) {
        this.dataAllowance = dataAllowance;
    }

    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public void setTelcoName(String telcoName) {
        this.telcoName = telcoName;
    }

    public void setUnliCallText(boolean unliCallText) {
        this.unliCallText = unliCallText;
    }
}
