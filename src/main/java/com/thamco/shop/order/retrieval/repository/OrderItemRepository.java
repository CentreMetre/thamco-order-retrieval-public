package com.thamco.shop.order.retrieval.repository;

import com.thamco.shop.order.retrieval.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the {@link OrderItem} class. Used in implementations to retrieve the {@link OrderItem}s from the database.
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>
{
    List<OrderItem> findByIdOrderId(Integer orderId);
}
