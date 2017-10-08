/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Arne
 */
public class Topping {

    private int toppingId;
    private String flavourTop;
    private int priceTop;

    public Topping(int toppingId, String flavourTop, int priceTop) {
        this.toppingId = toppingId;
        this.flavourTop = flavourTop;
        this.priceTop = priceTop;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public String getFlavourTop() {
        return flavourTop;
    }

    public void setFlavourTop(String flavourTop) {
        this.flavourTop = flavourTop;
    }

    public int getPriceTop() {
        return priceTop;
    }

    public void setPriceTop(int priceTop) {
        this.priceTop = priceTop;
    }
}
