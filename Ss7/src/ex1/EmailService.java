package ex1;

public class EmailService {
    public void sendEmail(Order order) {
        String email = order.getCustomer().getEmail();
        System.out.println("Da gui emai den " + email +
                ": Don hang " + order.getOrderId() + " da duoc tao");
    }
}
