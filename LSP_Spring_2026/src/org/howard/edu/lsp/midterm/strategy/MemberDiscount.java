package org.howard.edu.lsp.midterm.strategy;

/** 10% discount for member customers. @author Your Name */
public class MemberDiscount implements PricingStrategy {
    /** @param price original price @return price with 10% discount */
    public double applyDiscount(double price) { return price * 0.90; }
}