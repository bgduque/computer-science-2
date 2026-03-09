public class HazardousWasteCollector extends WasteCollector {

    @Override
    protected boolean canHandle(WasteContainer container) {
        return container.getWasteType() == WasteType.HAZARDOUS;
    }

    @Override
    protected void collect(WasteContainer container) {
        System.out.printf("  [HAZARDOUS COLLECTOR] Collecting %s (%.1f kg)%n",
                container.getId(), container.getCurrentLevel());
        System.out.printf("  [HAZARDOUS COLLECTOR] Sealing container for safe transport...%n");
        System.out.printf("  [HAZARDOUS COLLECTOR] Transporting to hazardous-waste treatment centre...%n");
        container.empty();
        System.out.printf("  [HAZARDOUS COLLECTOR] Container %s decontaminated and ready for reuse.%n%n",
                container.getId());
    }
}
