package FoodSupply;

public class SupplyDto {
    Supplier supplier;
    boolean isOrderReady;

    public SupplyDto(Supplier supplier, boolean isOrderReady) {
        this.supplier = supplier;
        this.isOrderReady = isOrderReady;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public boolean isOrderReady() {
        return isOrderReady;
    }
}
