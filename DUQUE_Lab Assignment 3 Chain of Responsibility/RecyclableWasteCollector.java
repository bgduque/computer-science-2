/**
 * Concrete handler for RECYCLABLE waste.
 * Sends recyclable waste to recycling plants.
 */
public class RecyclableWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getWasteType() == WasteType.RECYCLABLE;
    }

    @Override
    protected void collect(WasteContainer container) {
        System.out.printf("  [RECYCLABLE COLLECTOR] Collecting %s (%.1f kg)%n",
                container.getId(), container.getCurrentLevel());
        System.out.printf("  [RECYCLABLE COLLECTOR] Transporting to recycling plant...%n");
        container.empty();
        System.out.printf("  [RECYCLABLE COLLECTOR] Container %s emptied and ready for reuse.%n%n",
                container.getId());
    }
}
