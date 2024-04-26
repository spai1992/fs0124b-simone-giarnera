package classes;

import program.Main;

public class Customer {
    private Long id;
    private String name;
    private Integer tier;
    private long count = 0;

    public Customer(Long id, String name, Integer tier) {
        this.id = Main.customerId;

        this.count += 1;
        this.name = name;
        this.tier = tier;
    }

}
