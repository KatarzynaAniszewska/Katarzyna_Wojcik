package FoodSupply;

public class SupplyOrder {
    public Supplier supplier;
    public int quantity;
    public String productType;



    public SupplyOrder(final Supplier supplier, final int quantity, final String productType) {

        this.supplier = supplier;
        this.quantity = quantity;
        this.productType = productType;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductType() {
        return productType;
    }
}
