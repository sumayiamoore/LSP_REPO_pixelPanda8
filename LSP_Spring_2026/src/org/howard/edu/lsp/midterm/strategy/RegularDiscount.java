package org.howard.edu.lsp.midterm.strategy;

/** No discount applied for regular customers. @author Your Name */
public class RegularDiscount implements PricingStrategy {
    /** @param price original price @return same price, no discount */
    public double applyDiscount(double price) { return price; }
}