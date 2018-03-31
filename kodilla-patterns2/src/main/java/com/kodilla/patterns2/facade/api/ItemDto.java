package com.kodilla.patterns2.facade.api;

public class ItemDto {
    private final Long productId;
    private final double quanity;

    public ItemDto(Long productId, double quanity) {
        this.productId = productId;
        this.quanity = quanity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuanity() {
        return quanity;
    }
}
