package com.thamco.shop.order.retrieval;

import com.thamco.shop.order.retrieval.model.Order;
import com.thamco.shop.order.retrieval.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@Testcontainers
@ActiveProfiles("test")
public class OrderTest
{
    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("thamcotest")
            .withUsername("testusername")
            .withPassword("testpassword");

    @DynamicPropertySource
    static void configureTestDatabase(DynamicPropertyRegistry dynamicPropertyRegistry)
    {
        System.setProperty("DOCKER_HOST", "unix:///var/run/docker.sock");
        dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.jpa.hibernate.ddl-auto", () -> "create");
        dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testRetrievalWorks()
    {
        Order order = new Order();
        order.setId(1);
        order.setUserId(10);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);

        assertThat(orderRepository.findAll()).isNotEmpty();
        assertThat(orderRepository.findAll().get(0).getId()).isEqualTo(1);
        assertThat(orderRepository.findAll().get(0).getUserId()).isEqualTo(10);

    }
}
