package ex5.repository;

import ex5.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Da luu don hang " + order.getId());

    }

    public List<Order> findAll() {
        return orders;
    }
}
