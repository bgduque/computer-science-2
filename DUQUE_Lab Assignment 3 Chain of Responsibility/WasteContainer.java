/**
 * Represents a waste container with a specific type, capacity,
 * and current fill level.
 */
public class WasteContainer {

    private final String id;
    private final WasteType wasteType;
    private final double capacity;   // maximum capacity in kg
    private double currentLevel;     // current fill level in kg

    /**
     * Creates a new WasteContainer.
     * @param id        unique identifier for the container
     * @param wasteType type of waste this container holds
     * @param capacity  maximum capacity in kg
     */
    public WasteContainer(String id, WasteType wasteType, double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.id = id;
        this.wasteType = wasteType;
        this.capacity = capacity;
        this.currentLevel = 0;
    }

    /** Adds waste to the container. */
    public void addWaste(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.currentLevel = Math.min(this.currentLevel + amount, this.capacity);
    }

    /** Returns true when the container is at or above 90% capacity. */
    public boolean needsDisposal() {
        return currentLevel >= capacity * 0.9;
    }

    /** Returns true when the container is completely full. */
    public boolean isFull() {
        return currentLevel >= capacity;
    }

    /** Empties the container after disposal. */
    public void empty() {
        this.currentLevel = 0;
    }

    /** Returns the fill percentage (0-100). */
    public double getFillPercentage() {
        return (currentLevel / capacity) * 100.0;
    }

    // ---- Getters ----

    public String getId() {
        return id;
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public String toString() {
        return String.format("Container[%s | %s | %.1f/%.1f kg (%.0f%%)]",
                id, wasteType.getLabel(), currentLevel, capacity, getFillPercentage());
    }
}
