package com.thamco.shop.order.retrieval.service;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.model.OrderWithItems;

/**
 * Interface for retrieving orders from the database.
 */
public interface OrderService
{
    /**
     * Retrieves all orders from the database.
     * @return An iterable full of all orders
     */
    public Iterable<Order> getOrders();

    /**
     * Retrieves an order by a specific ID
     * @param Id the of the order to retrieve
     * @return {@link Order} object
     */
    public Order getOrderById(Integer Id);

    /**
     * Retrieves all current unfulfilled orders
     * @return An {@code Iterable<OrderWithItems>} with all unfulfilled orders.
     */
    Iterable<OrderWithItems> getUnfulfilledOrders();
}
