package org.howard.edu.lsp.midterm.strategy;

/** 20% discount for VIP customers. @author Your Name */
public class VIPDiscount implements PricingStrategy {
    /** @param price original price @return price with 20% discount */
    public double applyDiscount(double price) { return price * 0.80; }
}