package FoodSupply;

public class ExtraFoodShop implements SupplierProcess {

    @Override
    public boolean process(int quantity, String productType) {
        String firmName;

        System.out.println("Details of order: quantity "+ quantity+" of "+productType+" were confirmed by email.");
        return true;
    }
}
