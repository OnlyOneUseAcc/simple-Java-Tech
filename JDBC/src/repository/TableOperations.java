package repository;

import java.sql.SQLException;

/**
 * Interface TableOperations
 */
public interface TableOperations {
    /**
     * Create table
     * @throws SQLException database access error or other errors
     */
    void createTable() throws SQLException;
}
