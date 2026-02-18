package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

/**
 * Main entry point for the Assignment 3 ETL Pipeline.
 * Orchestrates the Extract, Transform, and Load steps using
 * dedicated classes for each responsibility.
 *
 * @author Sumayia Moore
 */
public class ETLPipeline {

    /** Path to the input CSV file. */
    private static final String INPUT_PATH  = "data/products.csv";

    /** Path to the output CSV file. */
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    /**
     * Main method. Runs the full ETL pipeline.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // ── EXTRACT ──────────────────────────────────────────────────────────
        File inputFile = new File(INPUT_PATH);
        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found: " + INPUT_PATH);
            return;
        }

        CSVReader reader = new CSVReader(INPUT_PATH);
        reader.process();

        List<Product> products = reader.getProducts();

        // ── TRANSFORM ────────────────────────────────────────────────────────
        ProductTransformer transformer = new ProductTransformer();
        transformer.transform(products);

        // ── LOAD ─────────────────────────────────────────────────────────────
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(OUTPUT_PATH))) {
            pw.println("ProductID,Name,Price,Category,PriceRange");
            for (Product p : products) {
                String priceStr = new BigDecimal(String.valueOf(p.getPrice()))
                        .toPlainString();
                pw.println(p.getProductId() + "," +
                           p.getName() + "," +
                           priceStr + "," +
                           p.getCategory() + "," +
                           p.getPriceRange());
            }
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
            return;
        }

        // ── RUN SUMMARY ───────────────────────────────────────────────────────
        System.out.println("=== ETL Pipeline Run Summary ===");
        System.out.println("Rows read (non-header):  " + reader.getTotalRead());
        System.out.println("Rows transformed:        " + products.size());
        System.out.println("Rows skipped:            " + reader.getTotalSkipped());
        System.out.println("Output written to:       " + OUTPUT_PATH);
    }
}
