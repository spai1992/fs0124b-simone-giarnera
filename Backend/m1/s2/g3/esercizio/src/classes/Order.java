package classes;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long id;
    private String status;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private List<Product> products;
    private Customer customers;

    public Order(String status, LocalDateTime orderDate, LocalDateTime deliveryDate, List<Product> products, Customer customers) {
        this.id = Main.
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customers = customers;
    }
}
