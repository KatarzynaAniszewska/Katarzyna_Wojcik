package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[]args){
        OrderSendingDetailsRetriever orderSendingDetailsRetriever = new OrderSendingDetailsRetriever();
        OrderSendingDetails orderSendingDetails=orderSendingDetailsRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailInformationService(),new ProductsOrdersRepository(),new ProductOrderService());
        orderProcessor.process(orderSendingDetails);
    }
}
