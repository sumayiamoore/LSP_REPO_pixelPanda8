package org.howard.edu.lsp.assignment3;

/**
 * Abstract base class for file handling operations in the ETL pipeline.
 * Provides a common foundation for classes that read from or write to files,
 * demonstrating inheritance as subclasses share this base structure.
 *
 * @author Sumayia Moore
 */
public abstract class FileHandler {

    /** The file path this handler operates on. */
    protected String filePath;

    /**
     * Constructs a FileHandler with the specified file path.
     *
     * @param filePath the path to the file
     */
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns the file path associated with this handler.
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Processes the file. Subclasses must implement this method
     * to define their specific file operation (read or write).
     */
    public abstract void process();
}
