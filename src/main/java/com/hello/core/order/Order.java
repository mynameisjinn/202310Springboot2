package com.hello.core.order;

public class Order {

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }


    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;


}
