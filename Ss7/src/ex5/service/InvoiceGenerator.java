package ex5.service;

import ex5.model.Order;
import ex5.model.OrderItem;

// tao hoa don
public class InvoiceGenerator {
    public void printInvoice(Order order) {
        System.out.println("=== HOA DON ===");
        for (OrderItem item : order.getItems()) {
            System.out.println(item.getProduct().getName() + " - So luong: " + item.getQuantity() + " - Thanh tien: " + item.getSubtotal());
        }
        System.out.println("Tong tien: " + order.getTotal());
    }
}
