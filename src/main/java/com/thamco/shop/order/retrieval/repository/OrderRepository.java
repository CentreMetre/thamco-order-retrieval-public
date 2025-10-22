package com.thamco.shop.order.retrieval.repository;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the {@link Order} class. Used in implementations to retrieve the {@link Order} from the database.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
    Iterable<Order> findByFulfilledNull();
}
