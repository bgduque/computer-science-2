public interface TelcoSubscription {
    String accept(UsagePromo promo);
    String accept(UnliCallOffer unli);
    String getTelcoName();
    double getPromoPrice();
    boolean getUnliCallText();
}
