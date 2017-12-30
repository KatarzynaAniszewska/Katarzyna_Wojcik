package FoodSupply;

public class GlutenFreeShop implements SupplierProcess {
    @Override
    public boolean process(int quantity, String productType) {
        System.out.println("The possibility to deliver "+quantity+" of "+productType+ "has been checked.");
        return false;
    }
}
