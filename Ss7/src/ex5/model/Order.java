package ex5.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    // them san pham vao don
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // tinh tong tien
    public double getTotal() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.getSubtotal();
        }
        return sum;
    }

    public String getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<OrderItem> getItems() {
        return items;
    }
}
