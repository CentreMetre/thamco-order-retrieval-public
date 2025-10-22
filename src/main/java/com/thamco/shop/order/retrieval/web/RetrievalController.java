package com.thamco.shop.order.retrieval.web;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.model.OrderItem;
import com.thamco.shop.order.retrieval.model.OrderWithItems;
import com.thamco.shop.order.retrieval.service.OrderItemService;
import com.thamco.shop.order.retrieval.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RetrievalController
{
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    public RetrievalController(OrderService orderService, OrderItemService orderItemService)
    {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }


// This SHOULD NOT be allowed to be released into production. This is a data security vulnerability.
    /**
     * Gets all orders places
     * @return An {@code Iterable} of all orders
     */
    @GetMapping("/orders/retrieve")
    public Iterable<Order> getOrders()
    {
        return orderService.getOrders();
    }

//    /**
//     * Gets all order items placed in orders
//     * @return An {@code Iterable} of all order items
//     */
//    @GetMapping("/orders/items")
//    public Iterable<OrderItem> getOrderItems()
//    {
//        return orderItemService.get();
//    }

    /**
     * The default page for this server.
     * @return A welcome message with current date and time
     */
    @GetMapping("/")
    public String retrievalIndex()
    {
        return("Welcome to retrieval. This page was rendered at " + LocalDateTime.now());
    }

    /**
     * Gets an order by its ID
     * @param order_id The ID of the order to get
     * @return An {@link Order} with the specified ID
     */
    @GetMapping("/orders/retrieve/{order_id}")
    public Order getOrderById(@PathVariable int order_id)
    {
        return orderService.getOrderById(order_id);
    }

    /**
     * Gets the {@link OrderItem}s of an order
     * @param orderId The ID of the order to get the items for
     * @return An {@code Iterable} of {@link OrderItem}s for the specified order
     */
    @GetMapping("/orders/retrieve/{order_id}/items")
    public Iterable<OrderItem> getOrderItemOfOrder(@PathVariable("order_id") int orderId)
    {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }

    /**
     * Gets all orders that have not been fulfilled, along with its order items
     * @return An {@code Iterable} of {@link OrderWithItems} of unfulfilled orders
     */
    @GetMapping("/orders/retrieve/unfulfilled")
    public Iterable<OrderWithItems> getUnfulfilledOrder()
    {
        return orderService.getUnfulfilledOrders();
    }
}
