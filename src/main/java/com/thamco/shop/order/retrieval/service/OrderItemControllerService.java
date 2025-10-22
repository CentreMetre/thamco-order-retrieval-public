package com.thamco.shop.order.retrieval.service;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.model.OrderItem;
import com.thamco.shop.order.retrieval.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemControllerService implements OrderItemService
{
    private final OrderItemRepository orderItemRepository;

    public OrderItemControllerService(OrderItemRepository orderItemRepository)
    {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Iterable<OrderItem> get()
    {
        return orderItemRepository.findAll();
    }

    @Override
    public Iterable<OrderItem> getOrderItemsByOrderId(int orderId)
    {
        return orderItemRepository.findByIdOrderId(orderId);
    }
}
