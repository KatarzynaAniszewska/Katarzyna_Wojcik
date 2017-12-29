package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private InformationService informationService;
    private OrderRepository orderRepository;
    private OrderService orderService;

    public OrderProcessor(final InformationService informationService, final OrderRepository orderRepository,
                          final OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }
    public OrderDto process(final OrderSendingDetails orderSendingDetails){
        boolean isSend = orderService.prepareOrder(orderSendingDetails.getClient(),orderSendingDetails.getPaid(),
                orderSendingDetails.getSend());
        if(isSend){
            informationService.inform(orderSendingDetails.getClient(),orderSendingDetails.getSend());
            orderRepository.createOrder(orderSendingDetails.getClient(),orderSendingDetails.getPaid(),orderSendingDetails.getSend());
            return new OrderDto(orderSendingDetails.getClient(),true);
        }else {
            return new OrderDto(orderSendingDetails.getClient(),false);
        }
    }
}
