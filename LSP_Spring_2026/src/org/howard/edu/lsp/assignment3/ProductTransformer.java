package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Handles the Transform step of the ETL pipeline.
 * Applies all required transformations to a list of Product objects
 * in the exact order specified by the assignment requirements.
 *
 * @author Sumayia Moore
 */
public class ProductTransformer {

    /**
     * Transforms a list of products by applying all required
     * transformations in order:
     * 1. Convert name to UPPERCASE
     * 2. Apply 10% discount if category is Electronics
     * 3. Assign Premium Electronics if final price exceeds $500
     * 4. Assign PriceRange based on final rounded price
     *
     * @param products the list of products to transform
     */
    public void transform(List<Product> products) {
        for (Product product : products) {
            applyTransformations(product);
        }
    }

    /**
     * Applies all transformations to a single Product.
     *
     * @param product the product to transform
     */
    private void applyTransformations(Product product) {

        // 1. Convert name to UPPERCASE
        product.setName(product.getName().toUpperCase());

        // 2. Apply 10% discount if Electronics
        String originalCategory = product.getCategory();
        BigDecimal price = new BigDecimal(String.valueOf(product.getPrice()));

        if ("Electronics".equalsIgnoreCase(originalCategory)) {
            price = price.multiply(new BigDecimal("0.90"));
        }

        // Round to 2 decimal places, half-up
        price = price.setScale(2, RoundingMode.HALF_UP);
        product.setPrice(price.doubleValue());

        // 3. Premium Electronics: final price > 500 AND original was Electronics
        if (price.compareTo(new BigDecimal("500.00")) > 0
                && "Electronics".equalsIgnoreCase(originalCategory)) {
            product.setCategory("Premium Electronics");
        }

        // 4. Assign PriceRange based on final rounded price
        product.setPriceRange(determinePriceRange(price));
    }

    /**
     * Determines the price range label based on the given price.
     *
     * @param price the final rounded price
     * @return the price range label: Low, Medium, High, or Premium
     */
    private String determinePriceRange(BigDecimal price) {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
