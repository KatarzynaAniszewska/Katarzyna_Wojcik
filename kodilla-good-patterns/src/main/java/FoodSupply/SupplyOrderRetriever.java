package FoodSupply;

public class SupplyOrderRetriever {
public SupplyOrder retrieve1(){
    Supplier supplier1 = new Supplier("ExtraFoodShop");
    int quantity1 =100;
    String productType1="vegetables";
    return new SupplyOrder(supplier1,quantity1,productType1);
}
public SupplyOrder retrieve2(){
    Supplier supplier2 = new Supplier("GlutenFreeShop");
    int quantity2=150;
    String productType2 = "breadstuff";
    return new SupplyOrder(supplier2,quantity2,productType2);
}
public SupplyOrder retrieve3(){
    Supplier supplier3=  new Supplier("HealthyShop");
    int quantity3=300;
    String productType3="meat";
    return new SupplyOrder(supplier3,quantity3,productType3);
}
}
