package com.thamco.shop.order.retrieval.service;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.model.OrderItem;
import com.thamco.shop.order.retrieval.model.OrderWithItems;
import com.thamco.shop.order.retrieval.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class OrderControllerService implements OrderService
{
    private final OrderRepository orderRepository;

    private final OrderItemService orderItemService;

    public OrderControllerService(OrderRepository orderRepository, OrderItemService orderItemService)
    {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
    }

    @Override
    public Iterable<Order> getOrders()
    {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer Id)
    {
        return orderRepository.findById(Id).orElse(null);
    }

    @Override
    public Iterable<OrderWithItems> getUnfulfilledOrders()
    {
        //Creating orderWithItems array to return after being filled
        ArrayList<OrderWithItems> ordersWithItems = new ArrayList<>();

        //Unfulfilled orders
        Iterable<Order> unfulfilledOrders = orderRepository.findByFulfilledNull();

        for (Order order : unfulfilledOrders)
        {
            //Creating new OrderWithItems object to add to the ordersWithItems
            OrderWithItems orderWithItems = new OrderWithItems();
            //Setting the OrderId of the current OrderWithItems
            orderWithItems.setOrderId(order.getId());

            //Getting list of OrderItemIds for the current Order
            Iterable<Integer> orderItemIds = getProductIdsFromOrderItems(order);
            //Setting to the current OrderWithItems the list of OrderItem Ids for the current order
            orderWithItems.setOrderItemIds(orderItemIds);

            //Adding the current OrderWithItems to the iterable of OrderWithItems to return
            ordersWithItems.add(orderWithItems);

        }

        return ordersWithItems;
    }

    /**
     * Extract the IDs of the order items given
     * @param order The order to get its order item IDs from
     * @return An {@code Iterable<Integer>} of IDs
     */
    private Iterable<Integer> getProductIdsFromOrderItems(Order order)
    {
        ArrayList<Integer> ids = new ArrayList<>();

        Iterable<OrderItem> items = orderItemService.getOrderItemsByOrderId(order.getId());

        for (OrderItem item : items)
        {
            ids.add(item.getProductId());
        }

        return ids;
    }
}
