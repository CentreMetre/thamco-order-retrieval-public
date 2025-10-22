package com.thamco.shop.order.retrieval.service;

import com.thamco.shop.order.retrieval.model.OrderItem;
import com.thamco.shop.order.retrieval.repository.OrderItemRepository;

/**
 * Interface for retrieving order items from the database via {@link OrderItemRepository}.
 */
public interface OrderItemService
{
    /**
     * Retrieves all order items from the database.
     * @return An {@code Iterable} of all order items in the database.
     */
    Iterable<OrderItem> get();

    /**
     * Retrieves all order items for a specific order.
     * @param orderId The ID of the order to get the items for.
     * @return An {@code Iterable} of order items for the specified order.
     */
    Iterable<OrderItem> getOrderItemsByOrderId(int orderId);
}
