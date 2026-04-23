package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class implementing the Template Method pattern.
 * Defines the fixed workflow for generating any report.
 */
public abstract class Report {

    /**
     * Template method — defines the fixed report generation workflow.
     * Declared final so subclasses cannot change the order of steps.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();
        System.out.println("=== BODY ===");
        formatBody();
        System.out.println("=== FOOTER ===");
        formatFooter();
    }

    /** Loads data required for the report. */
    protected abstract void loadData();

    /** Formats and prints the report header. */
    protected abstract void formatHeader();

    /** Formats and prints the report body. */
    protected abstract void formatBody();

    /** Formats and prints the report footer. */
    protected abstract void formatFooter();
}