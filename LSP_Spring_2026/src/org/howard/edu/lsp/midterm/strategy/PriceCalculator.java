package org.howard.edu.lsp.midterm.strategy;

/** Calculates final price using a pricing strategy. @author Your Name */
public class PriceCalculator {
    private PricingStrategy strategy;

    /** @param strategy the pricing strategy to use */
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /** @param price original price @return final discounted price */
    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}