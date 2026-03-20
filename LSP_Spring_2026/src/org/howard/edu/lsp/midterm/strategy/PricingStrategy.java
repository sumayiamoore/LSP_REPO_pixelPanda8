package org.howard.edu.lsp.midterm.strategy;

/** Strategy interface for calculating discounted prices. @author Your Name */
public interface PricingStrategy {
    /** @param price original price @return discounted price */
    double applyDiscount(double price);
}