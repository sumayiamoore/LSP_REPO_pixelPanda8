package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the Extract step of the ETL pipeline.
 * Reads and parses a CSV file into a list of Product objects,
 * skipping any rows that are malformed or contain invalid data.
 * Extends FileHandler to inherit common file path management.
 *
 * @author Sumayia Moore
 */
public class CSVReader extends FileHandler {

    /** List of successfully parsed products. */
    private List<Product> products;

    /** Total number of non-header rows encountered. */
    private int totalRead;

    /** Total number of rows skipped due to errors. */
    private int totalSkipped;

    /**
     * Constructs a CSVReader for the given file path.
     *
     * @param filePath the path to the input CSV file
     */
    public CSVReader(String filePath) {
        super(filePath);
        this.products = new ArrayList<>();
        this.totalRead = 0;
        this.totalSkipped = 0;
    }

    /**
     * Reads and parses the CSV file.
     * Skips blank lines, rows with wrong field count,
     * and rows with invalid ProductID or Price values.
     */
    @Override
    public void process() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                // Skip header row
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    totalRead++;
                    totalSkipped++;
                    continue;
                }

                totalRead++;
                String[] fields = line.split(",", -1);

                // Must have exactly 4 fields
                if (fields.length != 4) {
                    totalSkipped++;
                    continue;
                }

                // Trim all fields
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }

                // Validate ProductID
                int productId;
                try {
                    productId = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    totalSkipped++;
                    continue;
                }

                // Validate Price
                try {
                    new BigDecimal(fields[2]);
                } catch (NumberFormatException e) {
                    totalSkipped++;
                    continue;
                }

                double price = Double.parseDouble(fields[2]);
                products.add(new Product(productId, fields[1], price, fields[3]));
            }

        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }
    }

    /**
     * Returns the list of successfully parsed products.
     *
     * @return list of Product objects
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Returns the total number of non-header rows read.
     *
     * @return total rows read
     */
    public int getTotalRead() {
        return totalRead;
    }

    /**
     * Returns the total number of rows skipped.
     *
     * @return total rows skipped
     */
    public int getTotalSkipped() {
        return totalSkipped;
    }
}
