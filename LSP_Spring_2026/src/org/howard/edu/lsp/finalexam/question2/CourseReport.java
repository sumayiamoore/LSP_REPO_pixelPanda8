package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course.
 * Implements the variable steps of the Template Method pattern.
 */
public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    /**
     * Loads course data for the report.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Formats and prints the course report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    /**
     * Formats and prints the course report body.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Formats and prints the course report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}