package model;

import data.ProductMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Orderline> lines = new ArrayList();
    Orderline ol = new Orderline(1, 1, 1, 1, 1, 1, 1);

    public static void main(String[] args) throws SQLException {
        Cart cart = new Cart();
        System.out.println(cart.totalPrice(5, 7, 2));
        Orderline ol = new Orderline(1, 2, 5, 2, 5, 1, 10);
        System.out.println(ol.getBottomPrice());
        System.out.println(ol.getToppingPrice());

    }

    /**
     *
     * Adding an Orderline.
     *
     * @param userId Orderline needs a userId, to identify which user has made
     * the order.
     * @param bottomId Orderline needs a bottomId, to identify which bottomId
     * has been choosed.
     * @param bottomPrice To know what the price is for the chosen bottom.
     * @param toppingId Orderline needs a toppingId, to identify which toppingId
     * has been choosed.
     * @param toppingPrice To know what the price is for the chosen topping.
     * @param quantity To know how many bottom, and topping has been chosen.
     * @param totalPrice The total price of bottom and topping.
     * @throws SQLException
     */
    public void addOrderline(int userId, int bottomId, int bottomPrice, int toppingId, int toppingPrice, int quantity, int totalPrice) throws SQLException {

        Orderline ol = new Orderline(userId, bottomId, bottomPrice, toppingId, toppingPrice, quantity, totalPrice);
        lines.add(ol);
    }

    /**
     * totalPrice calculate how much the price is, for bottom and topping.
     *
     * @param bottomPrice to get the bottom price.
     * @param toppingPrice to get the topping price.
     * @param quantity to get the amount of topping and bottom.
     * @return totalPrice
     */
    public int totalPrice(int bottomPrice, int toppingPrice, int quantity) {

        int totalPrice = (bottomPrice + toppingPrice) * quantity;
        return totalPrice;
    }

    public List<Orderline> getLines() {
        return lines;
    }

    public void setLines(List<Orderline> lines) {
        this.lines = lines;
    }
}
