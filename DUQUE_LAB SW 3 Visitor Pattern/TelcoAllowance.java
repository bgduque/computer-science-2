import java.util.Map;

public class TelcoAllowance implements UsagePromo {

    private static final Map<String, Integer> dataMap = Map.of(
        "Smart", 15,
        "Globe", 10,
        "Ditto", 8
    );

    @Override
    public String showAllowance(String telcoName, double price) {
        var data = dataMap.getOrDefault(telcoName, 0);
        return data + " GB for ₱" + price;
    }
}
