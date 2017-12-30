package FoodSupply;

public class SupplyProcessor {
    private SupplierProcess supplierProcess;

    public SupplyProcessor(final SupplierProcess supplierProcess) {
        this.supplierProcess=supplierProcess;
    }
    public SupplyDto process(final SupplyOrder supplyOrder){
        System.out.println("Status of orders:");
        boolean isOrderReady = supplierProcess.process(supplyOrder.getQuantity(),supplyOrder.getProductType());
        if(isOrderReady){
            return new SupplyDto(supplyOrder.getSupplier(),true);

        }else return new SupplyDto(supplyOrder.getSupplier(),false);
    }
}
