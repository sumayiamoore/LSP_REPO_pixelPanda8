package org.howard.edu.lsp.assignment3;

/**
 * Represents a single product in the ETL pipeline.
 * Encapsulates all product data fields and provides
 * controlled access via getters and setters.
 *
 * @author Sumayia Moore
 */
public class Product {

    /** The unique product identifier. */
    private int productId;

    /** The name of the product. */
    private String name;

    /** The price of the product. */
    private double price;

    /** The category of the product. */
    private String category;

    /** The price range label (Low, Medium, High, Premium). */
    private String priceRange;

    /**
     * Constructs a Product with all required fields.
     *
     * @param productId the product ID
     * @param name      the product name
     * @param price     the product price
     * @param category  the product category
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the product ID.
     *
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the product price.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price the new product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the product category.
     *
     * @param category the new product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the price range label.
     *
     * @return the price range (Low, Medium, High, or Premium)
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the price range label.
     *
     * @param priceRange the price range label
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
