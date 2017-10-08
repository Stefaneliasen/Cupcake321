package model;

public class Orderline {

    private int bottomId;
    private int bottomPrice;
    private int toppingId;
    private int toppingPrice;
    private int quantity;
    private int totalPrice;
    private int userId;
    private int orderId;

    public Orderline(int userId, int bottomId, int bottomPrice, int toppingId, int toppingPrice, int quantity, int totalPrice) {
        this.bottomId = bottomId;
        this.bottomPrice = bottomPrice;
        this.toppingId = toppingId;
        this.toppingPrice = toppingPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.orderId = orderId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(int bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

}
