package FoodSupply;

public class HealthyShop implements SupplierProcess {
    @Override
    public boolean process(int quantity, String productType) {
        System.out.println("The truck to transport "+quantity+" of "+productType+" is waiting.");
        return true;
    }
}
