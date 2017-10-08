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
public class Bottom {

    private int bottomId;
    private String flavourBot;
    private int priceBot;

    public Bottom(int bottomId, String flavourBot, int priceBot) {
        this.bottomId = bottomId;
        this.flavourBot = flavourBot;
        this.priceBot = priceBot;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public String getFlavourBot() {
        return flavourBot;
    }

    public void setFlavourBot(String flavourBot) {
        this.flavourBot = flavourBot;
    }

    public int getPriceBot() {
        return priceBot;
    }

    public void setPriceBot(int priceBot) {
        this.priceBot = priceBot;
    }
}
