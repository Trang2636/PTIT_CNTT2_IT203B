package ex4.repository;

import ex4.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    private List<Order> orders=new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Da luu don hang vao file: "+order.getId());
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
