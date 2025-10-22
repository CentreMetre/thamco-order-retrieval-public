package com.thamco.shop.order.retrieval.model;

import java.util.List;

/**
 * A DTO that contains order IDs and a list of order item IDs part of that order.
 */
public class OrderWithItems
{
    private int orderId;

    private Iterable<Integer> orderItemIds;

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public Iterable<Integer> getOrderItemIds()
    {
        return orderItemIds;
    }

    public void setOrderItemIds(Iterable<Integer> orderItemIds)
    {
        this.orderItemIds = orderItemIds;
    }
}
