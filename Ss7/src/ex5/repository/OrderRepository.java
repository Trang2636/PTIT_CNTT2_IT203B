package ex5.repository;

import ex5.model.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
