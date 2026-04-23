package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to demonstrate the Template Method pattern.
 * Uses polymorphism to generate multiple report types.
 */
public class ReportDriver {

    /**
     * Main method to run the report generation demo.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report r : reports) {
            r.generateReport();
            System.out.println();
        }
    }
}