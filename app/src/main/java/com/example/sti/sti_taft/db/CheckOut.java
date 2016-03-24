package com.example.sti.sti_taft.db;

/**
 * Created by STI on 1/29/2016.
 */
public class CheckOut {

    private long checkOutId;
    private long orderId_FK;
    private double checkOutTotalPrice;

    public long getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(long checkOutId) {
        this.checkOutId = checkOutId;
    }

    public long getOrderId_FK() {
        return orderId_FK;
    }

    public void setOrderId_FK(long orderId_FK) {
        this.orderId_FK = orderId_FK;
    }

    public double getCheckOutTotalPrice() {
        return checkOutTotalPrice;
    }

    public void setCheckOutTotalPrice(double checkOutTotalPrice) {
        this.checkOutTotalPrice = checkOutTotalPrice;
    }
}
