package com.example.sti.sti_taft.db;

/**
 * Created by STI on 1/29/2016.
 */
public class Order {

    private long orderId;
    private long userId_FK;
    private long productId_FK;
    private double orderQuantity;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId_FK() {
        return userId_FK;
    }

    public void setUserId_FK(long userId_FK) {
        this.userId_FK = userId_FK;
    }

    public long getProductId_FK() {
        return productId_FK;
    }

    public void setProductId_FK(long productId_FK) {
        this.productId_FK = productId_FK;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
