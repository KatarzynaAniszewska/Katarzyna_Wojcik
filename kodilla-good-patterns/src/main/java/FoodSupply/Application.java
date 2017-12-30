package FoodSupply;

public class Application {
    public static void main (String []args){
        SupplyOrderRetriever supplyOrderRetriever = new SupplyOrderRetriever();
        SupplyOrder supplyOrder1 = supplyOrderRetriever.retrieve1();
        SupplyOrder supplyOrder2 = supplyOrderRetriever.retrieve2();
        SupplyOrder supplyOrder3 = supplyOrderRetriever.retrieve3();

        SupplyProcessor supplyProcessor1 = new SupplyProcessor(new ExtraFoodShop());
        SupplyProcessor supplyProcessor2 = new SupplyProcessor(new GlutenFreeShop());
        SupplyProcessor supplyProcessor3 = new SupplyProcessor(new HealthyShop());

        supplyProcessor1.process(supplyOrder1);
        supplyProcessor2.process(supplyOrder2);
        supplyProcessor3.process(supplyOrder3);



            }
        }



