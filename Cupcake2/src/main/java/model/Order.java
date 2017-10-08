package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int userId;
    private int orderId;
    private List<Orderline> orderlines = new ArrayList();

    public Order(int userId, List<Orderline> orderlines) {
        this.orderlines = orderlines;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<Orderline> orderlines) {
        this.orderlines = orderlines;
    }
}
