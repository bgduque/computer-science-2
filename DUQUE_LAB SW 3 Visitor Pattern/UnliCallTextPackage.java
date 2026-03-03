import java.util.Map;

public class UnliCallTextPackage implements UnliCallOffer {

    private static final Map<String, String> offerMap = Map.of(
        "Smart", "No unlimited calls and texts. Charged per use.",
        "Globe", "Unlimited calls and texts within Globe network only.",
        "Ditto", "Unlimited calls and texts to all networks."
    );

    @Override
    public String showUnliCallsTextOffer(String telcoName, boolean unliCallText) {
        if (!unliCallText) {
            return offerMap.getOrDefault(telcoName, "No unlimited calls and texts. Charged per use.");
        }
        return offerMap.getOrDefault(telcoName, "No offer available.");
    }
}
