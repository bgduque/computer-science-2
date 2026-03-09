/**
 * Enum representing the different types of waste
 * that the system can handle.
 */
public enum WasteType {
    ORGANIC("Organic"),
    RECYCLABLE("Recyclable"),
    HAZARDOUS("Hazardous");

    private final String label;

    WasteType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Parses a string into a WasteType (case-insensitive).
     * @param text the string to parse
     * @return the matching WasteType
     * @throws IllegalArgumentException if no match is found
     */
    public static WasteType fromString(String text) {
        for (WasteType type : WasteType.values()) {
            if (type.label.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown waste type: " + text
                + ". Valid types: Organic, Recyclable, Hazardous");
    }
}
