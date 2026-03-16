package ex4.repository;

import ex4.model.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
