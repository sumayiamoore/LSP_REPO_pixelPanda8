package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: Sumayia Moore
 * @param args
 */

public class ETLPipeline {

	
	public static void main(String[] args) {
		
		String inputPath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		
		File inputFile = new File(inputPath);
		if (!inputFile.exists()) {
			System.out.println("Error: Input file not found: " + inputPath);
			return;
		}
		
		List<String[]> validRows  = new ArrayList<>();
        int totalRead    = 0;
        int totalSkipped = 0;
        String headerLine = null;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    headerLine = line;   // preserve header exactly
                    firstLine  = false;
                    continue;
                }

                // blank line
                if (line.trim().isEmpty()) {
                    totalRead++;
                    totalSkipped++;
                    continue;
                }

                totalRead++;
                String[] fields = line.split(",", -1);

                // must have exactly 4 fields
                if (fields.length != 4) {
                    totalSkipped++;
                    continue;
                }

                // trim all fields
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }

                // validate ProductID
                try {
                    Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    totalSkipped++;
                    continue;
                }

                // validate Price
                try {
                    new BigDecimal(fields[2]);
                } catch (NumberFormatException e) {
                    totalSkipped++;
                    continue;
                }

                validRows.add(fields);
            }

        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        // ── TRANSFORM ────────────────────────────────────────────────────────
        List<String[]> outputRows = new ArrayList<>();

        for (String[] row : validRows) {
            // row: [ProductID, Name, Price, Category]
            String productId       = row[0];
            String name            = row[1];
            String originalCategory = row[3];

            // 1. Name → UPPERCASE
            String transformedName = name.toUpperCase();

            // 2. Electronics → 10% discount
            BigDecimal price = new BigDecimal(row[2]);
            if ("Electronics".equalsIgnoreCase(originalCategory)) {
                price = price.multiply(new BigDecimal("0.90"));
            }

            // Round to 2 decimal places, half-up
            price = price.setScale(2, RoundingMode.HALF_UP);

            // 3. Premium Electronics: final price > 500 AND original was Electronics
            String category = originalCategory;
            if (price.compareTo(new BigDecimal("500.00")) > 0
                    && "Electronics".equalsIgnoreCase(originalCategory)) {
                category = "Premium Electronics";
            }

            // 4. PriceRange based on final rounded price
            String priceRange;
            int cmp10  = price.compareTo(new BigDecimal("10.00"));
            int cmp100 = price.compareTo(new BigDecimal("100.00"));
            int cmp500 = price.compareTo(new BigDecimal("500.00"));

            if (cmp10 <= 0) {
                priceRange = "Low";
            } else if (cmp100 <= 0) {
                priceRange = "Medium";
            } else if (cmp500 <= 0) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }

            // Format price with exactly 2 decimal places
            String priceStr = price.toPlainString();

            outputRows.add(new String[]{productId, transformedName, priceStr, category, priceRange});
        }

        // ── LOAD ─────────────────────────────────────────────────────────────
        // Ensure data/ directory exists
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            pw.println("ProductID,Name,Price,Category,PriceRange");
            for (String[] row : outputRows) {
                pw.println(String.join(",", row));
            }
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
            return;
        }

        // ── RUN SUMMARY ───────────────────────────────────────────────────────
        int totalTransformed = outputRows.size();
        System.out.println("=== ETL Pipeline Run Summary ===");
        System.out.println("Rows read (non-header):  " + totalRead);
        System.out.println("Rows transformed:        " + totalTransformed);
        System.out.println("Rows skipped:            " + totalSkipped);
        System.out.println("Output written to:       " + outputPath);
    }
}
