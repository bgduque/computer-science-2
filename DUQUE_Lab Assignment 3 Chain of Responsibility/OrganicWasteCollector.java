public class OrganicWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getWasteType() == WasteType.ORGANIC;
    }

    @Override
    protected void collect(WasteContainer container) {
        System.out.printf("  [ORGANIC COLLECTOR] Collecting %s (%.1f kg)%n",
                container.getId(), container.getCurrentLevel());
        System.out.printf("  [ORGANIC COLLECTOR] Transporting to composting facility...%n");
        container.empty();
        System.out.printf("  [ORGANIC COLLECTOR] Container %s emptied and ready for reuse.%n%n",
                container.getId());
    }
}
