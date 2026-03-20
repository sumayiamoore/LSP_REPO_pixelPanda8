package org.howard.edu.lsp.midterm.strategy;

/** 15% discount for holiday customers. @author Your Name */
public class HolidayDiscount implements PricingStrategy {
    /** @param price original price @return price with 15% discount */
    public double applyDiscount(double price) { return price * 0.85; }
}